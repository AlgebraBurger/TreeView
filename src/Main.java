import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Butchokoi on 1/17/2016.
 */
public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;

    public  static  void  main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TreeView");

        TreeItem<String> root,julpo,korinai;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Julpo
        julpo = makeBranch("Julpo",root);
        makeBranch("Jul",julpo);
        makeBranch("Po",julpo);

        //Korinai
        korinai = makeBranch("Korinai",root);
        makeBranch("Kori",korinai);
        makeBranch("Nai",korinai);

        //Create Tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> {
            if(newValue != null){
                System.out.println(newValue.getValue());
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private  TreeItem<String> makeBranch(String title,TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}

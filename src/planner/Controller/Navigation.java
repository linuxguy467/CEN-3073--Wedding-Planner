package planner.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

/**
 *
 * Created by mchemingway0031 on 2/25/2016.
 */
public class Navigation
{
    private final Scene scene;

    public Navigation(Stage stage, int x, int y)
    {
        scene = new Scene(new Pane(), x, y);
        stage.setScene(scene);
    }

    public void loadAndShow(String sUrl)
    {
        try {
            //loads the fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(sUrl));
            Node root = fxmlLoader.load();

            Controller controller = fxmlLoader.getController();
            controller.setContents(root);

            scene.setRoot((Parent) controller.getContents());
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

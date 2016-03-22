package planner.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Navigation.class.getResource(sUrl));
        } catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

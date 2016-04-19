package planner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import planner.GUI.Main;

/**
 * Controller for Packages.fxml
 * Created by mchem on 4/18/2016.
 */
public class PackageController
{
    @FXML private MenuItem backButton;

    @FXML
    private void initialize()
    {
        backButton.setOnAction(event -> {
            try {
                Main main = new Main();
                main.closeStage();
                main.setFXML("planner/GUI/Menu.fxml");
                main.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

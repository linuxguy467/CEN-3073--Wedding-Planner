package planner.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import planner.Controller.MainController;

import java.sql.SQLException;

/**
 * Main.java
 * Main method for the Wedding Planner application
 */
public class Main extends Application {

    private static Stage stage;
    private String URL_FXML = "planner/GUI/log_in.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Wedding Planner Pro!");
        stage.setOnCloseRequest(event -> {
            if(MainController.conn[0] != null)
            {
                try {
                    MainController.conn[0].close();
                } catch (SQLException e) {
                    //e.printStackTrace();
                }
            }
            event.consume();
            closeStage();
            System.exit(0);
        });

        switch (URL_FXML) {
            case "planner/GUI/log_in.fxml":
                switchScene(650, 350);
                stage.setResizable(false);
                break;
            case "planner/GUI/Main.fxml":
                switchScene(800, 650);
                stage.setResizable(false);
                break;
            case "planner/GUI/Menu.fxml":
                switchScene(800, 650);
                stage.setResizable(false);
                break;
            case "planner/GUI/Packages.fxml":
                switchScene(800, 750);
                stage.setResizable(false);
                break;
            case "planner/GUI/Quote.fxml":
                switchScene(800, 750);
                stage.setResizable(false);
                break;
        }


        stage.show();
    }

    public void closeStage()
    {
        stage.close();
    }

    private void switchScene(int x, int y)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/"+ URL_FXML));
            stage.setScene(new Scene(root, x, y));
        }catch (Exception ioe)
        {
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void setFXML(String URL_FXML) {
        this.URL_FXML = URL_FXML;
    }
}

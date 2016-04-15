package planner.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;
    private String URL_FXML = "planner/GUI/log_in.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Wedding Planner Pro!");
        stage.setOnCloseRequest(event -> {
            event.consume();
            closeStage();
            System.exit(0);
        });

        if(URL_FXML.equals("planner/GUI/log_in.fxml"))
        {
            switchScene(650, 350);
        }else if(URL_FXML.equals("planner/GUI/create_client.fxml"))
        {
            switchScene(550, 500);
        }else if(URL_FXML.equals("planner/GUI/create_base.fxml"))
        {
            switchScene(800, 650);
        }

        stage.setResizable(false);
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

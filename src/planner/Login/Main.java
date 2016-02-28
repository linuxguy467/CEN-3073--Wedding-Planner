package planner.Login;

import javafx.application.Application;
import javafx.stage.Stage;
import planner.Controller.Navigation;

public class Main extends Application {

    private static Navigation navigation;

    public static Navigation getNavigation()
    {
        return navigation;
    }

    @Override
    public void start(Stage primaryStage) {
        navigation = new Navigation(primaryStage, 650, 370);

        primaryStage.setTitle("Wedding Planner Pro!");
        primaryStage.setResizable(false);
        primaryStage.show();

        Main.getNavigation().loadAndShow("log_in.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

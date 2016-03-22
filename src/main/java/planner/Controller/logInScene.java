package planner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import planner.GUI.Main;

/**
 *
 * Created by mchemingway0031 on 2/25/2016.
 */
public class logInScene
{


    @FXML private MenuItem closeButton;
    @FXML private PasswordField passwordField;
    @FXML private Label wrongLogInText;
    @FXML private TextField userNameTextField;
    @FXML private Button logInButton;
    @FXML private MenuItem createUserButton;

    /**
     * FXML accessed method.
     * Handles events from objects.
     */
    @FXML
    private void initialize() {

        /**
         * A click of the login button retrieves
         * Username and the corresponding password and matches them to
         * those searched from database.
         */
        logInButton.setOnAction(event -> {
            if (userNameTextField.getText().equals("defaultuser") &&
                    passwordField.getText().equals("password")) {
                try {
                    Main main = new Main();
                    main.closeStage();
                    main.setFXML("create_base.fxml");
                    main.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                wrongLogInText.setFont(Font.font(null, FontWeight.BOLD, 12));
                wrongLogInText.setText("Invalid Login");
            }
        });

        userNameTextField.setOnMouseClicked(event ->
                wrongLogInText.setText(null));

        passwordField.setOnMouseClicked(event ->
                wrongLogInText.setText(null));

        closeButton.setOnAction(event ->
                System.exit(0));

        createUserButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Added Yet!");
            alert.setHeaderText(null);
            alert.setContentText("Stay Tuned for the final product!");

            alert.showAndWait();
        });
    }
}

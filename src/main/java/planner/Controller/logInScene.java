package planner.Controller;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import planner.GUI.Main;
import planner.Util.databaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * logInScene.java
 * Controller for the log_in.fxml file loaded into FXMLLoader
 * Created by mchemingway0031 on 2/25/2016.
 */
public class logInScene
{
    @FXML private MenuItem closeButton;
    @FXML private PasswordField passwordField;
    @FXML private Label wrongLogInText;
    @FXML private TextField userNameTextField;
    @FXML private Button logInButton;

    static String first_name, last_name;
    static final Connection[] conn = new Connection[1];
    /**
     * FXML accessed method.
     * Handles events from objects.
     */
    @FXML
    private void initialize() {

        /** Establish connection with MySQL database
         *  to check for username and password */

        final Service<Connection> connectionThread = new Service<Connection>() {
            @Override
            protected Task<Connection> createTask() {
                return new Task<Connection>() {
                    @Override
                    protected Connection call() throws Exception {
                        conn[0] = databaseConnection.connectToDatabase();
                        return conn[0];
                    }
                };
            }
        };

        connectionThread.restart();
        /**
         * A click of the login button retrieves
         * Username and the corresponding password and matches them to
         * those searched from database.
         */
        logInButton.setOnAction(event -> {
            if(conn[0] != null)
            {
                Statement statement = null;
                String user = " ", pass = " ";
                try {
                    statement = conn[0].createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM Login WHERE email= " + "'" +
                            userNameTextField.getText() + "'" + "AND password= "+ "'" +
                            passwordField.getText() + "'");
                    while(rs.next())
                    {
                        if(rs.getString("email") != null && rs.getString("password") != null)
                        {
                            user = rs.getString("email");
                            pass = rs.getString("password");
                            first_name = rs.getString("firstN");
                            last_name = rs.getString("lastN");
                        }
                    }
                    statement.close();
                } catch (SQLException e) {
                    System.out.println(e.getSQLState() + "\n"
                            + e.getMessage() + "\t" + e.getErrorCode());
                }

                if (userNameTextField.getText().equals(user) &&
                        passwordField.getText().equals(pass)) {
                    try {
                        conn[0].close();
                        Main main = new Main();
                        main.closeStage();
                        main.setFXML("planner/GUI/Menu.fxml");
                        main.start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Service<Void> showWrongTextThread = new Service<Void>() {
                        @Override
                        protected Task<Void> createTask() {
                            return new Task<Void>() {

                                @Override
                                protected Void call() throws Exception {
                                    wrongLogInText.setFont(Font.font(null, FontWeight.BOLD, 12));
                                    updateMessage("Invalid Login!");
                                    return null;
                                }
                            };
                        }
                    };

                    showWrongTextThread.setOnSucceeded(event1 ->
                            wrongLogInText.textProperty().unbind()
                    );

                    wrongLogInText.textProperty().bind(
                            showWrongTextThread.messageProperty());
                    showWrongTextThread.restart();
                }
            }

        });

        userNameTextField.setOnMouseClicked(event -> {
            Service<String> changeWrongTextThread = new Service<String>() {
                @Override
                protected Task<String> createTask() {
                    return new Task<String>() {
                        @Override
                        protected String call() throws Exception {
                            return null;
                        }
                    };
                }
            };


            wrongLogInText.setText(changeWrongTextThread.getValue());
            changeWrongTextThread.restart();
        });

        passwordField.setOnMouseClicked(event -> {
            Service<String> changeWrongTextThread = new Service<String>() {
                @Override
                protected Task<String> createTask() {
                    return new Task<String>() {
                        @Override
                        protected String call() throws Exception {
                            return null;
                        }
                    };
                }
            };

            wrongLogInText.setText(changeWrongTextThread.getValue());
            changeWrongTextThread.restart();
        });

        closeButton.setOnAction(event ->
                System.exit(0));

        /*createUserButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Service<Alert> alertThread = new Service<Alert>() {
                @Override
                protected Task<Alert> createTask() {
                    return new Task<Alert>() {
                        @Override
                        protected Alert call() throws Exception {

                            alert.setTitle("Not Added Yet!");
                            alert.setHeaderText(null);
                            alert.setContentText("Stay Tuned for " +
                                    "the final product!");


                            return alert;
                        }
                    };
                }
            };
            alertThread.setOnSucceeded(event1 ->
                    alert.showAndWait());
            alertThread.restart();

        });*/
    }
}

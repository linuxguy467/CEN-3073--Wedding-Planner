package planner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import planner.GUI.Main;

/**
 *
 * Created by mchemingway0031 on 2/25/2016.
 */
public class createUserScene extends Controller
{
    public static final String URL_FXML = "create_user.fxml";

    @FXML private DatePicker birthDatePicker;
    @FXML private Label invalidFieldText;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField streetAddressField;
    @FXML private TextField phoneNumberField;
    @FXML private TextArea descriptionArea;
    @FXML private MenuItem backButton;
    @FXML private MenuItem closeButton;
    @FXML private Button createButton;

    @FXML private void initialize()
    {
        backButton.setOnAction(event ->
                Main.getNavigation().loadAndShow(logInScene.URL_FXML));
        closeButton.setOnAction(event ->
                System.exit(0));
        createButton.setOnAction(event -> {
            if(!firstNameField.getText().matches("^[a-zA-Z]*$")
                    || !firstNameField.getText().equals(" "))
            {

                invalidFieldText.setFont(Font.font(null, FontWeight.BOLD, 12));
                invalidFieldText.setText("Field(s) Missing or Invalid");
            }else if(!lastNameField.getText().matches("^[a-zA-Z]*$")
                    || lastNameField.getText().equals(" "))
            {

                invalidFieldText.setFont(Font.font(null, FontWeight.BOLD, 12));
                invalidFieldText.setText("Field(s) Missing or Invalid");
            }else if(!streetAddressField.getText().matches(
                    "\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+ " +
                            "(?:Avenue|Lane|Road|Boulevard|Drive|Street|Court|North|South|" +
                            "East|WestAve|Dr|Rd|Blvd|Ln|St|Ct|N|S|E|W)\\.?"))
            {
                invalidFieldText.setFont(Font.font(null, FontWeight.BOLD, 12));
                invalidFieldText.setText("Field(s) Missing or Invalid");
            }else if(!phoneNumberField.getText().matches("^[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$"))
            {

                invalidFieldText.setFont(Font.font(null, FontWeight.BOLD, 12));
                invalidFieldText.setText("Field(s) Missing or Invalid");
            }else if(birthDatePicker.getValue() == null)
            {

                invalidFieldText.setFont(Font.font(null, FontWeight.BOLD, 12));
                invalidFieldText.setText("Field(s) Missing or Invalid");
            }else
            {
                descriptionArea.getText();
            }
        });
    }
}

package planner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import planner.GUI.Main;
import planner.Util.databaseConnection;

public class createClientScene {

    @FXML
    private MenuItem backButton;
    @FXML
    private MenuItem closeButton;
    @FXML
	private Button Submit;
	//Client Information
	@FXML 
	private TextField G_firstName;
	@FXML 
	private TextField G_middleName;
	@FXML 
	private TextField G_lastName;
	@FXML 
	private TextField B_firstName;
	@FXML 
	private TextField B_middleName;
	@FXML 
	private TextField B_lastName;
	@FXML
	private TextField address_1;
	@FXML 
	private TextField address_2;
	@FXML 
	private TextField city;
	@FXML 
	private TextField state;
	@FXML 
	private TextField zip;
	@FXML
	private TextField contactNumber;
	@FXML	
	private TextField altNumber;
	@FXML
	private TextField Email;
	
	//Wedding Information
	@FXML 
	private TextField venueName;
	@FXML 
	private TextField venueAddress_1;
	@FXML 
	private TextField venueAddress_2;
	@FXML 
	private TextField venueCity;
	@FXML 
	private TextField venueState;
	@FXML 
	private TextField venueZip;
	@FXML
	private TextField venueNumber;
	@FXML
	private TextField V_firstName;
	@FXML
	private TextField V_lastName;
	@FXML 
	private TextField weddingStart;
	@FXML 
	private TextField weddingEnd;
	@FXML
	private DatePicker weddingDate;

    @FXML
    private void initialize()
    {
        Submit.setOnAction(event ->
                databaseConnection.addToDatabase(
                        G_firstName.getText(), G_lastName.getText(), B_firstName.getText(),
                        B_lastName.getText(), Email.getText(), contactNumber.getText())
        );

        closeButton.setOnAction(event -> System.exit(0));

        backButton.setOnAction(event -> {
            try {
                Main main = new Main();
                main.closeStage();
                main.setFXML("planner/GUI/create_base.fxml");
                main.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

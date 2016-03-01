package planner.Controller;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import planner.GUI.Main;

public class createClientScene extends Controller{

    public static final String URL_FXML = "create_client.fxml";

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
        BufferedWriter reader;
        File plannerFile = new File("planner.txt");
        try {
            if(!plannerFile.exists())
            {
                try {
                    plannerFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reader= new BufferedWriter(new PrintWriter(plannerFile));

            Submit.setOnAction(event -> {
                try {

                    reader.write(G_firstName.getText() + " " +
                            G_middleName.getText() + " " +
                            G_lastName.getText());
                    reader.newLine();

                    reader.write(B_firstName.getText() + " " + B_middleName.getText() + " " + B_lastName.getText());
                    reader.newLine();

                    reader.write(address_1.getText());
                    reader.newLine();

                    reader.write(address_2.getText());
                    reader.newLine();

                    reader.write(city.getText() + " " + state.getText() + " " + zip.getText());
                    reader.newLine();

                    reader.write(contactNumber.getText());
                    reader.newLine();

                    reader.write(altNumber.getText());
                    reader.newLine();

                    reader.write(Email.getText());
                    reader.newLine();
                    reader.newLine();

                    reader.write(weddingDate.getValue().getYear() +
                            weddingDate.getValue().getMonth().toString() +
                            weddingDate.getValue().getDayOfMonth());
                    reader.newLine();

                    reader.write(weddingStart.getText() + "-" + weddingEnd.getText());
                    reader.newLine();

                    reader.write(venueName.getText());
                    reader.newLine();

                    reader.write(V_firstName.getText() + " " + V_lastName.getText());
                    reader.newLine();

                    reader.write(venueAddress_1.getText());
                    reader.newLine();

                    reader.write(venueAddress_2.getText());
                    reader.newLine();

                    reader.write(venueCity.getText() + ", " + venueState.getText() + " " + venueZip.getText());
                    reader.newLine();

                    reader.write(venueNumber.getText());
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            closeButton.setOnAction(event ->
                    System.exit(0));

            backButton.setOnAction(event ->
                    Main.getNavigation().loadAndShow(createBaseScene.URL_FXML));
        }catch (FileNotFoundException nf)
        {
            nf.printStackTrace();
        }


    }
}

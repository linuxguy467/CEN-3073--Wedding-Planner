package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

	@FXML
	Button Submit;
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
	private TextField weddingDate;

//saves information to text file
public void seeText(ActionEvent evt){
		
		if (evt.getSource() == Submit){
			
			PrintWriter wt = null;
			
			try{
				 wt = new PrintWriter("planner.txt");
				 BufferedWriter reader = new BufferedWriter(wt);
				reader.write(G_firstName.getText() +" " + G_middleName.getText() + " " + G_lastName.getText());
				reader.newLine();
				reader.write(B_firstName.getText() +" " + B_middleName.getText() + " " + B_lastName.getText());
				reader.newLine();
				reader.write(address_1.getText());
				reader.newLine();
				reader.write(address_2.getText());
				reader.newLine();
				reader.write(city.getText() +" " + state.getText() + " " + zip.getText());
				reader.newLine();
				reader.write(contactNumber.getText());
				reader.newLine();
				reader.write(altNumber.getText());
				reader.newLine();
				reader.write(Email.getText());
				reader.newLine();
				reader.newLine();
				reader.write(weddingDate.getText());
				reader.newLine();
				reader.write(weddingStart.getText() +"-" + weddingEnd.getText());
				reader.newLine();
				reader.write(venueName.getText());
				reader.newLine();
				reader.write(V_firstName.getText() +" " + V_lastName.getText());
				reader.newLine();
				reader.write(venueAddress_1.getText());
				reader.newLine();
				reader.write(venueAddress_2.getText());
				reader.newLine();
				reader.write(venueCity.getText() +", " + venueState.getText() + " " + venueZip.getText());
				reader.newLine();
				reader.write(venueNumber.getText());
				reader.close();
				
			}
			catch(IOException e){
				
				e.printStackTrace();
			
				
				
			}
			// closes the Stage
			Stage stage = (Stage) Submit.getScene().getWindow();
			stage.close();
		}
		
	}
}

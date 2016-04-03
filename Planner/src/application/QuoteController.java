package application;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuoteController  {
	@FXML
	private Label showPrice;
	@FXML
	private Button Submit;
	@FXML
	private Button Package1;
	@FXML
	private Button Package2;
	@FXML
	private Button Package3;
	@FXML
	private Button Package4;
	@FXML
	private TextField Title;
	@FXML
	private TextField quoteFirstName;
	@FXML
	private TextField quoteLastName;
	@FXML
	private TextField quoteContactNum;
	@FXML
	private TextField quoteWeddingDate;
	@FXML
	private TextField quoteChairCover;
	@FXML
	private TextField quoteSashe;
	@FXML
	private TextField quoteCover_Sashe;
	@FXML
	private TextField quoteTableRun;
	@FXML
	private TextField quoteTableLin;
	@FXML
	private TextField quoteTallCenter;
	@FXML
	private TextField quoteSmallVase;
	@FXML
	private TextField quoteRoseRunner;
	@FXML
	private TextField quoteRoseSkirt;
	@FXML
	private TextField quoteLaceCloth;
	@FXML
	private TextField quoteTableSkirt;
	@FXML
	private TextField quotePillars;
	@FXML
	private TextField quoteGlassVase;
	@FXML
	private TextField quoteGuest;
	@FXML 
	private CheckBox cb1;
	@FXML 
	private CheckBox cb2;
	@FXML 
	private CheckBox cb3;
	@FXML 
	private CheckBox cb4;
	@FXML 
	private CheckBox cb5;
	@FXML 
	private CheckBox cb6;
	@FXML 
	private CheckBox cb7;
	@FXML 
	private CheckBox cb8;
	@FXML 
	private CheckBox cb9;
	@FXML 
	private CheckBox cb10;
	@FXML 
	private CheckBox cb11;
	@FXML 
	private CheckBox cb12;
	@FXML 
	private CheckBox cb13;
	
	
	@FXML
	public void printCost()throws IOException{
	
	
	if (Package1.isArmed()){	
		showPrice.setText("1500");
	}
	else if(Package2.isArmed()){
		showPrice.setText("2500");
	}
	else if(Package3.isArmed()){
	showPrice.setText("3500");
	}
	else if(Package4.isArmed()){
	showPrice.setText("4500");
}
	}
	
	@FXML
	public void showCost()throws IOException{
		
	}
	@FXML
	private void goHome() throws IOException{
		
		Main.showMenu();
	}
public void seeText(ActionEvent evt) throws IOException{
		
		if (evt.getSource() == Submit){
			
			PrintWriter wt = null;
			
			try{
				 wt = new PrintWriter("quote.txt");
				 BufferedWriter reader = new BufferedWriter(wt);
				reader.write();
				reader.newLine();
				
				reader.close();
				
			}
			catch(IOException e){
				
				e.printStackTrace();
			
				
				
			}
			
		
		}
		Main.showMenu();
	}

}

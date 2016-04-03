package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateAccountController  implements Initializable{
	
	@FXML
	private Button Submit;
	@FXML
	private Button Delete;
	@FXML
	private Button Add;
	@FXML
	private Button Addname;
	@FXML
	private TableView<Table2> Party;
	@FXML
	private TableColumn<Table2,String> Titlename;
	@FXML
	private TableColumn<Table2, String> firstname;
	@FXML
	private TableColumn<Table2, String> lastname;
	@FXML
	private TextField Gfirst ;
	@FXML
	private TextField  Gmiddle;
	@FXML
	private TextField  Glast;
	@FXML
	private TextField  Bfirst;
	@FXML
	private TextField  Bmiddle;
	@FXML
	private TextField  Blast;
	@FXML
	private TextField  Cnumber;
	@FXML
	private TextField  CAnumber;
	@FXML
	private TextField  Email;
	@FXML
	private TextField  Ceremony;
	@FXML
	private TextField  Cfirst;
	@FXML
	private TextField  Clast;
	@FXML
	private TextField  Cstart;
	@FXML
	private TextField  Cend;
	@FXML
	private TextField  Caddress1;
	@FXML
	private TextField  Caddress2;
	@FXML
	private TextField  Ccity;
	@FXML
	private TextField  Cstate;
	@FXML
	private TextField  Czip;
	@FXML
	private TextField  CCnumber;
	@FXML
	private TextField  Reception;
	@FXML
	private TextField  Rfirst;
	@FXML
	private TextField  Rlast;
	@FXML
	private TextField  Rstart;
	@FXML
	private TextField  Rend;
	@FXML
	private TextField  Raddress1;
	@FXML
	private TextField  Raddress2;
	@FXML
	private TextField  Rcity;
	@FXML
	private TextField  Rstate;
	@FXML
	private TextField  Rzip;
	@FXML
	private TextField  RCnumber;
	@FXML
	private TextField  BFflower;
	@FXML
	private TextField GFflower ;
	@FXML
	private TextField  Wflower;
	@FXML
	private TextField  NumberHonor;
	@FXML
	private TextField  NumberBestmen;
	@FXML
	private TextField  NumberMaids;
	@FXML
	private TextField  NumberGrooms;
	@FXML
	private TextField  NumberGuest;
	@FXML
	private TextField  Tsize;
	@FXML
	private TextField  NumberGtable;
	@FXML
	private TextField ptitle;
	@FXML
	private TextField Pfirst;
	@FXML
	private TextField Plast;
	@FXML
	private TextArea special;
	@FXML
	private DatePicker weddingDate;
	@FXML
	private CheckBox yes;
	@FXML
	private CheckBox Romantic;
	@FXML
	private CheckBox Soft;
	@FXML
	private CheckBox Simple;
	@FXML
	private CheckBox Casual;
	@FXML
	private CheckBox Formal;
	@FXML
	private CheckBox Extravagant;
	@FXML
	private CheckBox Traditional;
	@FXML
	private ColorPicker color1;
	@FXML
	private ColorPicker color2;
	@FXML
	private ColorPicker AccentColor;
	@FXML
	private ChoiceBox weddingPackages;
	@FXML
	private ChoiceBox<?> title;
	
	// index for delete item
	@FXML
	private IntegerProperty index = new SimpleIntegerProperty();
	
	//create table data
	@FXML
	 ObservableList<Table2> data = FXCollections.observableArrayList(
			new Table2 ("BestMan","John","Jackson")
		
			);
	 @FXML
		private void goHome() throws IOException{
			
			Main.showMenu();
		}
			@FXML
		private void backCreate() throws IOException{
			Main.showCreateScene();
		}
		
		@FXML
		private void nextCreate() throws IOException{
			
			Main.showCreateScene();
		}
		@FXML
		private void goAdd() throws IOException{
			
			Main.showAdd();
		}
		
		
	@FXML
	public void onAddItem(ActionEvent event){
		
		//updates the table when data is added
		Table2 entry = new Table2(ptitle.getText(),Pfirst.getText(),Plast.getText());
		
		//add data to table
		data.add(entry);
		
		// clear the textfields
		clearForm();
		
	}
	@FXML
	public void onDeleteItem(ActionEvent event){
		
		int i = index.get();
		if(i > -1){
			data.remove(i);
			Party.getSelectionModel().clearSelection();
		}
		
	}
	public void clearForm(){
		
		ptitle.clear();
		Pfirst.clear();
		Plast.clear();
	}
	
	
	@FXML	
	public void seeText(ActionEvent evt) throws IOException{
			
			if (evt.getSource() == Submit){
				
				PrintWriter wt = null;
				
				try{
					 wt = new PrintWriter("planner.txt");
					 BufferedWriter reader = new BufferedWriter(wt);
					reader.write(Gfirst.getText() +" " + Gmiddle.getText() + " " + Glast.getText());
					reader.newLine();
					reader.write(Bfirst.getText() +" " + Bmiddle.getText() + " " + Blast.getText());
					reader.newLine();
					reader.write(Ceremony.getText());
					reader.newLine();
					reader.write(Caddress1.getText());
					reader.newLine();
					reader.write(Caddress2.getText());
					reader.newLine();
					reader.write(Ccity.getText() +" " + Cstate.getText() + " " + Czip.getText());
					reader.newLine();
					reader.write(CCnumber.getText());
					reader.newLine();
					reader.write(CAnumber.getText());
					reader.newLine();
					reader.write(Email.getText());
					reader.newLine();
					reader.newLine();
					reader.write(weddingDate.getPromptText());
					reader.newLine();
					reader.write(Cstart.getText() +"-" + Cend.getText());
					reader.newLine();
					reader.write(Reception.getText());
					reader.newLine();
					reader.write(Rfirst.getText() +" " + Rlast.getText());
					reader.newLine();
					reader.write(Raddress1.getText());
					reader.newLine();
					reader.write(Raddress2.getText());
					reader.newLine();
					reader.write(Rcity.getText() +", " + Rstate.getText() + " " + Rzip.getText());
					reader.newLine();
					reader.write(RCnumber.getText());
					reader.close();
					
				}
				catch(IOException e){
					
					e.printStackTrace();
				}
				
			
			}
			Main.showMenu();
		}
public void initialize(URL url, ResourceBundle resource) {
		
		index.set(-1);
		Titlename.setCellValueFactory(new PropertyValueFactory<Table2,String>("Title"));
		firstname.setCellValueFactory(new PropertyValueFactory<Table2,String>("firstname"));
		lastname.setCellValueFactory(new PropertyValueFactory<Table2,String>("lastname"));
		
		Party.setItems(data);
		
		//get the index when clicking on table row
		Party.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
	
			public void changed(ObservableValue<?>obserable,Object oldValue, Object newValue){
				index.set(data.indexOf(newValue));
			}
		});
		
	}
}

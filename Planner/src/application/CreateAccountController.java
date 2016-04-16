package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateAccountController implements Initializable{

	private ItemListController grandtotal;
	@FXML private Label addtional;
	@FXML private Button Back;
	@FXML private Button addItem;
	@FXML private Button Submit;
	@FXML private Button Delete;
	@FXML private Button Add;
	@FXML private Button Addname;
	@FXML private Button Item;
	@FXML private TableView<Party> table;
	@FXML private TableColumn<Party, String> Titlename;
	@FXML private TableColumn<Party, String> firstname;
	@FXML private TableColumn<Party, String> lastname;
	@FXML private TextField Gfirst ;
	@FXML private TextField  Gmiddle;
	@FXML private TextField  Glast;
	@FXML private TextField  Bfirst;
	@FXML private TextField  Bmiddle;
	@FXML private TextField  Blast;
	@FXML private TextField  Cnumber;
	@FXML private TextField  CAnumber;
	@FXML private TextField  Email;
	@FXML private TextField  Ceremony;
	@FXML private TextField  Cfirst;
	@FXML private TextField  Clast;
	@FXML private TextField  Cstart;
	@FXML private TextField  Cend;
	@FXML private TextField  Caddress1;
	@FXML private TextField  Caddress2;
	@FXML private TextField  Ccity;
	@FXML private TextField  Cstate;
	@FXML private TextField  Czip;
	@FXML private TextField  CCnumber;
	@FXML private TextField  Reception;
	@FXML private TextField  Rfirst;
	@FXML private TextField  Rlast;
	@FXML private TextField  Rstart;
	@FXML private TextField  Rend;
	@FXML private TextField  Raddress1;
	@FXML private TextField  Raddress2;
	@FXML private TextField  Rcity;
	@FXML private TextField  Rstate;
	@FXML private TextField  Rzip;
	@FXML private TextField  RCnumber;
	@FXML private TextField  BFflower;
	@FXML private TextField GFflower ;
	@FXML private TextField  Wflower;
	@FXML private TextField  NumberHonor;
	@FXML private TextField  NumberBestmen;
	@FXML private TextField  NumberMaids;
	@FXML private TextField  NumberGrooms;
	@FXML private TextField  NumberGuest;
	@FXML private TextField  Tsize;
	@FXML private TextField  NumberGtable;
	@FXML private TextField ptitle;
	@FXML private TextField Pfirst;
	@FXML private TextField Plast;
	
	@FXML private TextField itemGuest;
	@FXML private TextArea special;
	@FXML private DatePicker weddingDate;
	@FXML private CheckBox yes;
	@FXML private CheckBox Romantic;
	@FXML private CheckBox Soft;
	@FXML private CheckBox Simple;
	@FXML private CheckBox Casual;
	@FXML private CheckBox Formal;
	@FXML private CheckBox Extravagant;
	@FXML private CheckBox Traditional;
	
	@FXML private ColorPicker color1;
	@FXML private ColorPicker color2;
	@FXML private ColorPicker AccentColor;
	@FXML private ChoiceBox<String> weddingPackages;
	@FXML private ChoiceBox<?> title;
	
	
	
	//create table data
	@FXML
	 final ObservableList<Party> data = FXCollections.observableArrayList(
			new Party("BestMan","John","Jackson")
	);
	
	// create List for choice box packages
	@FXML
	 final ObservableList<String> weddingPackageList = FXCollections.observableArrayList
	 		("Package 1","Package 2","Package 3","Package 4");
	
	// index for delete item
	@FXML
	private IntegerProperty index = new SimpleIntegerProperty();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		index.set(-1); //updates the table after deleting selecting row
		
		Titlename.setCellValueFactory(new PropertyValueFactory<Party, String>("Title"));
		firstname.setCellValueFactory(new PropertyValueFactory<Party, String>("firstname"));
		lastname.setCellValueFactory(new PropertyValueFactory<Party, String>("lastname"));
		
		//adds names to arraylist data
		table.setItems(data);
		
		// listens for changes in table
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>(){
		
		//updates the data arraylist
		public void changed(ObservableValue<?>obserable,Object oldValue, Object newValue){
				index.set(data.indexOf(newValue));
			}});
		
		// adds packages to select package choicebox
		weddingPackages.setItems(weddingPackageList);
		weddingPackages.setValue(" ");
		
		}
	
	//
	@FXML
	public void onAddItem(ActionEvent event){
		
		//updates the table when data is added
		Party entry = new Party(ptitle.getText(),Pfirst.getText(),Plast.getText());
		
		//add data to table
		data.add(entry);
		
		// clear the textfields
		clearForm();
	}
	
	// removes selected row with the delete button
	@FXML
	public void onDeleteItem(ActionEvent event)throws IOException{
		
		int i = index.get();
		if(i > -1){
			data.remove(i);
			table.getSelectionModel().clearSelection();
		}
		
	}
	
	// clears the text fields after data is added to table
	public void clearForm()
	{
		ptitle.clear();
		Pfirst.clear();
		Plast.clear();
	}
	
	// adds ceremony information to reception fields
	@FXML
	public void samePlace(ActionEvent event) throws IOException
	{
		//if yes check box in selected adds information to reception fields
		if (yes.isSelected())
		{
			// gets ceremony text fields text and set them to reception text fields
			String make = Ceremony.getText();
			Reception.setPromptText(make);
		}
	}
	
	
	
	// goes to the main menu on button click
	@FXML
	private void goHome() throws IOException{
		
		Main.showMenu();
	}
	
	// goes to item select on button click
	@FXML
	private void showItems() throws IOException{
		
		
		Main.showAdd();
		
	}
	
	
}

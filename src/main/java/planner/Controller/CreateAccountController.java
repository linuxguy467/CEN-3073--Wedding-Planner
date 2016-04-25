package planner.Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import planner.GUI.Main;
import planner.Util.databaseConnection;

import javax.management.relation.RelationNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class CreateAccountController{

	@FXML private TextField Cname;
	@FXML private Label addtional;
	@FXML private MenuItem Back;
	@FXML private Button addItem;
	@FXML private MenuItem Submit;
	@FXML private Button Delete;
	@FXML private Button Add;
	@FXML private Button Addname;
	@FXML private Button Item;
	@FXML private TableView<Party> table;
	@FXML private TableColumn<Party, String> Titlename;
	@FXML private TableColumn<Party, String> firstname;
	@FXML private TableColumn<Party, String> lastname;
	@FXML private TextField  Gfirst ;
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
	@FXML private TextField itemChairCover;
	@FXML private TextField itemSashe;
	@FXML private TextField itemCover_Sashe;
	@FXML private TextField itemTableRun;
	@FXML private TextField itemTableLin;
	@FXML private TextField itemTallCenter;
	@FXML private TextField itemSmallVase;
	@FXML private TextField itemRoseRunner;
	@FXML private TextField itemRoseSkirt;
	@FXML private TextField itemLaceCloth;
	@FXML private TextField itemTableSkirt;
	@FXML private TextField itemPillars;
	@FXML private TextField itemGlassVase;
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
	
	@FXML
	private void initialize() {
		MainController.welcomeThread.restart();

		Back.setOnAction(event -> {
			try {
				Main main = new Main();
				main.closeStage();
				main.setFXML("planner/GUI/Menu.fxml");
				main.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Submit.setOnAction(event -> {
			if(weddingDate.getValue() != null)
			{
				LocalDate localDate = weddingDate.getValue();
				Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
				Date date = Date.from(instant);
				java.sql.Date wedd_date = new java.sql.Date(date.getTime());

				String first_color = " ", second_color = " ", acolor = " ", wedding_style = " ";
				if(color1.getValue() != null)
				{
					Color color = color1.getValue();
					first_color = color.toString();
				}

				if(color2.getValue() != null)
				{
					Color color3 = color2.getValue();
					second_color = color3.toString();
				}

				if(AccentColor.getValue() != null)
				{
					Color acc_color = AccentColor.getValue();
					acolor = acc_color.toString();
				}

				if(Romantic.isSelected())
				{
					wedding_style = "Romantic";
				}else if(Soft.isSelected())
				{
					wedding_style = "Soft";
				}else if(Simple.isSelected())
				{
					wedding_style = "Simple";
				}else if(Casual.isSelected())
				{
					wedding_style = "Casual";
				}else if(Formal.isSelected())
				{
					wedding_style = "Formal";
				}else if(Extravagant.isSelected())
				{
					wedding_style = "Extravagant";
				}else if(Traditional.isSelected())
				{
					wedding_style = "Traditional";
				}else
				{
					wedding_style = " ";
				}

				if(!Gfirst.getText().isEmpty() && !Gmiddle.getText().isEmpty()&&
						!Glast.getText().isEmpty() && !Bfirst.getText().isEmpty()&&
						!Bmiddle.getText().isEmpty() && !Blast.getText().isEmpty()&&
						!Cname.getText().isEmpty() &&
						!Cfirst.getText().isEmpty() && !Clast.getText().isEmpty() &&
						!Cstart.getText().isEmpty() && !Cend.getText().isEmpty() &&
						!Caddress1.getText().isEmpty() && !Ccity.getText().isEmpty() &&
						!Cstate.getText().isEmpty() && !CCnumber.getText().isEmpty() &&
						!Reception.getText().isEmpty() && !Rfirst.getText().isEmpty() &&
						!Rlast.getText().isEmpty() && !Rstart.getText().isEmpty() &&
						!Rend.getText().isEmpty() && !Raddress1.getText().isEmpty() &&
						!Rcity.getText().isEmpty() && !Rstate.getText().isEmpty() &&
						RCnumber.getText().matches("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$") &&
						Czip.getText().matches("\\d\\d\\d\\d\\d") && NumberGrooms.getText().matches("\\d") &&
						NumberHonor.getText().matches("\\d") && NumberBestmen.getText().matches("\\d") &&
						NumberGrooms.getText().matches("\\d") && NumberGtable.getText().matches("\\d") &&
						NumberGuest.getText().matches("\\d") && NumberMaids.getText().matches("\\d") &&
						Tsize.getText().matches("\\d") && Rzip.getText().matches("\\d\\d\\d\\d\\d") &&
						Email.getText().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$") &&
						Cnumber.getText().matches("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$") &&
						CCnumber.getText().matches("^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$")){

					databaseConnection.addToDatabase(Gfirst.getText(), Gmiddle.getText(), Glast.getText(),
							Bfirst.getText(), Bmiddle.getText(), Blast.getText(), wedd_date, Cnumber.getText(),
							CAnumber.getText(), Email.getText());
					databaseConnection.addToDatabase(Cname.getText(), Cfirst.getText(),
							Clast.getText(), Cstart.getText(), Cend.getText(), Caddress1.getText(),
							Caddress2.getText(), CCnumber.getText(), Ccity.getText(), Cstate.getText(),
							Integer.parseInt(Czip.getText()));
					databaseConnection.addToDB(Reception.getText(), Rfirst.getText(),
							Rlast.getText(), Rstart.getText(), Rend.getText(),
							Raddress1.getText(), Raddress2.getText(), RCnumber.getText(),
							Rcity.getText(), Rstate.getText(), Integer.parseInt(Rzip.getText()));
					databaseConnection.addToDatabase(Wflower.getText(), first_color,
							second_color, acolor, BFflower.getText(), GFflower.getText(),
							wedding_style, Integer.parseInt(NumberHonor.getText()),
							Integer.parseInt(NumberBestmen.getText()),
							Integer.parseInt(NumberMaids.getText()),
							Integer.parseInt(NumberGrooms.getText()),
							Integer.parseInt(NumberGuest.getText()), Integer.parseInt(Tsize.getText()),
							Integer.parseInt(NumberGtable.getText()));
					for(Party party : data)
					{
						databaseConnection.addToDatabase(party.getTitle(),
								party.getFirstname(), party.getLastname());
					}
					Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
					successAlert.setTitle("Success!");
					successAlert.setHeaderText("Added!");
					successAlert.setContentText("Successfully Added to Database!");
					successAlert.show();
				}else
				{
					Alert successAlert = new Alert(Alert.AlertType.ERROR);
					successAlert.setTitle("Error!");
					successAlert.setHeaderText("Missing Data!");
					successAlert.setContentText("Could not send data, " +
							"data could be missing or invalid!");
					successAlert.show();
				}

			}else
			{
				Alert successAlert = new Alert(Alert.AlertType.ERROR);
				successAlert.setTitle("Error!");
				successAlert.setHeaderText("Missing Data!");
				successAlert.setContentText("Could not send data, " +
						"data could be missing or invalid!");
				successAlert.show();
			}
		});
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
		//databaseConnection.addToDatabase(ptitle.getText(), Pfirst.getText(), Plast.getText());
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
			Reception.setText(Cname.getText());
			Rfirst.setText(Cfirst.getText());
			Rlast.setText(Clast.getText());
			Rstart.setText(Cstart.getText());
			Rend.setText(Cend.getText());
			Raddress1.setText(Caddress1.getText());
			Raddress2.setText(Caddress2.getText());
			Rcity.setText(Ccity.getText());
			Rstate.setText(Cstate.getText());
			Rzip.setText(Czip.getText());
			RCnumber.setText(CCnumber.getText());
		}
	}

	@FXML
	private void showItems() throws IOException{
		
		
		//Main.showAdd();
		
	}
}

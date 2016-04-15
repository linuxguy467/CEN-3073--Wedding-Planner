package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController  {
	
	private Main main;
	
	@FXML
	private Button create;
	
	// goes to Create Account on button click
	@FXML
	private void goCreate() throws IOException
	{
		Main.showCreateScene();
	}
	
	// goes to Create Quote on button click
	@FXML
	private void goQuote() throws IOException
	{
		Main.showQuote();
	}
	
	// goes to View Packages on button click
	@FXML
	private void goPack() throws IOException
	{
		Main.showPack();
	}
	
	// goes to Menu on button click
	@FXML
	private void goHomenow() throws IOException
	{
		Main.showMenu();
	}




}

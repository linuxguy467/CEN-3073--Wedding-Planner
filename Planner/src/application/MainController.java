package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainController  {
	
	private Main main;
	
	@FXML
	private Button create;
	@FXML
	private void goCreate() throws IOException
	{
		Main.showCreateScene();
	}
	
	
	@FXML
	private void goQuote() throws IOException{
		
		Main.showQuote();
	}
	@FXML
	private void goPack() throws IOException
	{
		Main.showPack();
	}
	@FXML
	private void goHomenow() throws IOException{
		
		Main.showMenu();
	}




}

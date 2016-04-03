package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Wedding Planner");
		showMenu();
		
		
		
	}
	public static void showMenu() throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Menu.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void showCreateScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Main.fxml"));
		BorderPane createAccount2 = loader.load();
		mainLayout.setCenter(createAccount2);
	}

	public static void showQuote() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Quote.fxml"));
		BorderPane createQuote = loader.load();
		mainLayout.setCenter(createQuote);
	}
	public static void showPack() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Packages.fxml"));
		BorderPane packageShow = loader.load();
		mainLayout.setCenter(packageShow);
	}
	/**public static void showPackages() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Packages.fxml"));
		BorderPane Makepackages = loader.load();
		mainLayout.setCenter(Makepackages);
	}**/
	public static void showAdd() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/PopupTable.fxml"));
		BorderPane AddParty = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add to Party");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(AddParty);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}
	
	public static void main(String[] args){
		launch(args);
		
	}
	
	
}

package planner.Controller;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import planner.GUI.Main;
import planner.Util.databaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Controller for the main application menu.
 */
public class MainController  {
	@FXML private MenuItem connectDatabase;
	@FXML private Label DBstateLabel;
	//private Main main;
	
	@FXML private Button create;
	@FXML private Button createQuote;
	@FXML private Button viewPacks;
	@FXML private MenuItem closeButton;
	@FXML private MenuItem logoutButton;
	@FXML private Text welcomeText;

	public static final Connection[] conn = new Connection[1];
	static Service<Connection> welcomeThread;

	@FXML private void initialize()
	{
		/** Establish connection with MySQL database
	      *  to check for username and password */

		;
		welcomeThread = new Service<Connection>() {
			@Override
			protected Task<Connection> createTask() {
				return new Task<Connection>() {

					@Override
					protected Connection call() throws Exception {
						conn[0] = databaseConnection.connectToDatabase();
						updateMessage(databaseConnection.ping(conn[0]).getText());
						return conn[0];
					}
				};
			}
		};
		welcomeThread.setOnSucceeded(event ->
				DBstateLabel.textProperty().unbind());

		DBstateLabel.textProperty().bind(welcomeThread.messageProperty());

		welcomeThread.restart();
		/**
		 * Adds a welcome message to display on main GUI page
		 */
		Service<Void> selectTask = new Service<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						updateMessage("Welcome" + " " +
								logInScene.first_name + " " + logInScene.last_name);
						return null;
					}
				};
			}
		};

		/**Unbinds the welcomeText Text label from the service
		 * thread*/
		selectTask.setOnSucceeded(event1 ->
				welcomeText.textProperty().unbind()
		);

		/**
		 * Binds the message in selectTask service to the welcome
		 * text
		 */
		welcomeText.textProperty().bind(
				selectTask.messageProperty()
		);

		selectTask.restart();

		connectDatabase.setOnAction(event -> {
			Service<Void> pingThread = new Service<Void>() {
				@Override
				protected Task<Void> createTask() {
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							updateMessage(databaseConnection.ping(conn[0]).getText());
							return null;
						}
					};
				}
			};

			pingThread.setOnSucceeded(event1 ->
					DBstateLabel.textProperty().unbind());


			pingThread.restart();
		});
		/**
		 * Create Account Button
		 */
		create.setOnAction(event -> {
			try {
				Main main = new Main();
				main.closeStage();
				main.setFXML("planner/GUI/Main.fxml");
				main.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		/**
		 * Create Quote Button
		 */
		createQuote.setOnAction(event -> {
			try {
				Main main = new Main();
				main.closeStage();
				main.setFXML("planner/GUI/Quote.fxml");
				main.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		/**
		 * View Packages Button!
		 */
		viewPacks.setOnAction(event -> {
			try {
				Main main = new Main();
				main.closeStage();
				main.setFXML("planner/GUI/Packages.fxml");
				main.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		/**
		 * logs out of the application
		 */
		logoutButton.setOnAction(event -> {
			try {
				Main main = new Main();
				conn[0].close();
				main.closeStage();
				main.setFXML("planner/GUI/log_in.fxml");
				main.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		closeButton.setOnAction(event -> {
			try {
				conn[0].close();
				System.exit(0);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}
	

	// goes to Menu on button click
	@FXML
	private void goHomenow() throws IOException
	{
		try {
			Main main = new Main();
			main.closeStage();
			main.setFXML("planner/GUI/Menu.fxml");
			main.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}

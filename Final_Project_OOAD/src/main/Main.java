package main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	Scene scene;
	Label titleLBL, passwordLBL, usernameLBL,nameLBL;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	TextField firstNameTXT,lastnameTXT, usernameTXT;
	PasswordField passwordTXT;
	Button submitBtn;
	DatePicker datepicker;
	Spinner<Integer> ageSpinner;
	CheckBox agreeCB;
	
	void initialize() {
		titleLBL = new Label("Register Here");
		passwordLBL = new Label("Password");
		usernameLBL = new Label("UserName");
		nameLBL = new Label("Name");
		
		borderContainer = new BorderPane();
		flowContainer = new FlowPane();
		gridContainer = new GridPane();
		firstNameTXT = new TextField();
		lastnameTXT = new TextField();
		usernameTXT = new TextField();
		passwordTXT = new PasswordField();
		submitBtn = new Button("Register");
		datepicker = new DatePicker();
		
		agreeCB = new CheckBox("Agree");
		ageSpinner = new Spinner<Integer>(0,99,13);
		
		
		scene = new Scene(borderContainer,600,400);
		
	}
	void addComponent() {
		borderContainer.setTop(titleLBL);
		borderContainer.setCenter(gridContainer);
		gridContainer.add(nameLBL, 0, 0);
		gridContainer.add(usernameLBL, 0, 1);
		gridContainer.add(passwordLBL, 0, 2);
		flowContainer.getChildren().add(firstNameTXT);
		flowContainer.getChildren().add(lastnameTXT);
		gridContainer.add(flowContainer, 1, 0);
		gridContainer.add(usernameTXT, 1,1);
		gridContainer.add(passwordTXT, 1, 2);
		borderContainer.setBottom(submitBtn);
		gridContainer.add(datepicker, 1, 3);
		gridContainer.add(ageSpinner, 1, 4);
		gridContainer.add(agreeCB, 1, 5);
		
	}
	
	void arrageComponents() {
		firstNameTXT.setMinWidth(100);
		lastnameTXT.setMinWidth(100);
		usernameTXT.setMinWidth(100);
		passwordTXT.setMinWidth(100);
		
		firstNameTXT.setMaxWidth(200);
		lastnameTXT.setMaxWidth(200);
		usernameTXT.setMaxWidth(300);
		passwordTXT.setMaxWidth(300);
		
		BorderPane.setAlignment(titleLBL, Pos.CENTER);
		BorderPane.setAlignment(gridContainer, Pos.CENTER);
		BorderPane.setAlignment(flowContainer, Pos.CENTER);
	BorderPane.setAlignment(submitBtn, Pos.CENTER);
	gridContainer.setAlignment(Pos.CENTER);
	borderContainer.setPadding(new Insets(10));
	flowContainer.setHgap(10);
	gridContainer.setHgap(30);
	gridContainer.setVgap(10);
	titleLBL.setPadding(new Insets(5));
	submitBtn.setPadding(new Insets(5));
	
	
//	fafasfaf
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		addComponent();
		arrageComponents();
		primaryStage.setTitle("Register Form");
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
}

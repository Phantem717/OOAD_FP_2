package main;
import Model.users;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Util.Connect;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login {
	Scene scene;
	Label usernameLBL,titleLBL,passwordLBL;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	TextField usernameTXT;
	PasswordField passwordTXT;
	Button submitBtn;
	Stage stage;
	private users user;
	private Connect connect = Connect.getInstance();
    private ArrayList<users> userList = new ArrayList<>();

	void initialize() {
		titleLBL = new Label("Login");
		passwordLBL = new Label("Password");
		usernameLBL = new Label("Username");
		
		usernameTXT = new TextField();
		passwordTXT = new PasswordField();
		
		borderContainer = new BorderPane();
		flowContainer = new FlowPane();
		gridContainer = new GridPane();
		
		submitBtn = new Button("Login");
		scene = new Scene(borderContainer,600,400);

	}
	
	void addComponent() {
		borderContainer.setTop(titleLBL);
		borderContainer.setCenter(gridContainer);
		gridContainer.add(usernameLBL, 0, 1);
		gridContainer.add(passwordLBL, 0, 2);
		gridContainer.add(usernameTXT, 1, 1);
		gridContainer.add(passwordTXT, 1, 2);
		borderContainer.setBottom(submitBtn);

	}
	
	void arrangeComponents() {
		usernameTXT.setMinWidth(100);
		passwordTXT.setMinWidth(100);
	

		usernameTXT.setMaxWidth(300);
		passwordTXT.setMaxWidth(300);

		
		BorderPane.setAlignment(titleLBL, Pos.CENTER);
		BorderPane.setAlignment(gridContainer, Pos.BASELINE_CENTER);
		BorderPane.setAlignment(flowContainer, Pos.CENTER);
	BorderPane.setAlignment(submitBtn, Pos.CENTER);
	gridContainer.setAlignment(Pos.CENTER);
	borderContainer.setPadding(new Insets(10));
	flowContainer.setHgap(10);
	gridContainer.setHgap(30);
	gridContainer.setVgap(10);
	titleLBL.setPadding(new Insets(5));
	submitBtn.setPadding(new Insets(5));
	}
	public void Login(String username, String password) {
		String query = "SELECT * FROM users";
		connect.rs = connect.execQuery(query);
		try {
			while(connect.rs.next()) {
				Integer dbuser_id = connect.rs.getInt("user_id");
				String dbusername = connect.rs.getString("username");
				String dbpassword = connect.rs.getString("password");
				String dbphoneNumber = connect.rs.getString("phone_number");
				String dbAddress = connect.rs.getString("address");
				String dbrole = connect.rs.getString("role");
	            userList.add(new users(dbuser_id, dbusername, dbpassword, dbphoneNumber, dbAddress, dbrole));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for (users users : userList) {
			  if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
				  users LoggedIn = new users(users.getUser_id(), users.getUsername(), users.getPassword(), users.getPhoneNumber(), users.getAddress(), users.getRole());
//				  System.out.println(LoggedIn.getUsername());
				  if(users.getRole().equalsIgnoreCase("admin")) {
					  new HomeSeller(stage,LoggedIn);
				  }
				  else if(users.getRole().equalsIgnoreCase("buyer")) {
					  new HomeBuyer(stage,LoggedIn);
				  }
				  else if(users.getRole().equalsIgnoreCase("seller")) {
					  new HomeSeller(stage,LoggedIn);
				  }
				  else {
					  Alert alert = new Alert(AlertType.ERROR);
					  alert.setTitle("Incorrect Credetnials");
					  alert.setContentText("Please Try Again");
					  alert.showAndWait();
				  }
			  }
		}
	}
	void initAction() {
		try {
			submitBtn.setOnAction(e ->{
				String username = usernameTXT.getText().trim();
		        String password = passwordTXT.getText().trim();			
		        
		        
		        if(!(username.isEmpty() || username.isEmpty())) {
				       Login(username, password);

		        }
		        
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public Login(Stage arg0) {
		initialize();
		addComponent();
		arrangeComponents();
		initAction();
		 
	        this.stage = arg0;
	        arg0.setScene(scene);
	        arg0.show();	}

} 
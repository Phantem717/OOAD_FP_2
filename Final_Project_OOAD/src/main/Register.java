package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import Util.Connect;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.users;

public class Register {
    Scene scene;
    Label titleLBL, passwordLBL, usernameLBL, addressLBL, phoneNumberLBL, rolesLBL;
    BorderPane borderContainer;
    GridPane gridContainer;
    FlowPane flowContainer;
    TextField usernameTXT, phoneNumberTXT, addressTXT;
    PasswordField passwordTXT;
    Button submitBtn;
    RadioButton seller, buyer, admin;
    Stage stage;
    private users user;
    private Connect connect = Connect.getInstance();
    private ArrayList<users> userList = new ArrayList<>();
    ToggleGroup group = new ToggleGroup();

    // Variable to store the selected role
    private String selectedRole;

    void initialize() {
        titleLBL = new Label("Register Here");
        passwordLBL = new Label("Password");
        usernameLBL = new Label("UserName");
        addressLBL = new Label("Address");
        phoneNumberLBL = new Label("Phone Number");
        rolesLBL = new Label("Roles");

        borderContainer = new BorderPane();
        flowContainer = new FlowPane();
        gridContainer = new GridPane();

        usernameTXT = new TextField();
        passwordTXT = new PasswordField();
        phoneNumberTXT = new TextField();
        addressTXT = new TextField();
        submitBtn = new Button("Register");
        seller = new RadioButton("Seller");
        buyer = new RadioButton("Buyer");
        admin = new RadioButton("Admin");
        seller.setToggleGroup(group);
        buyer.setToggleGroup(group);
        admin.setToggleGroup(group);

        scene = new Scene(borderContainer, 600, 400);
    }

    void addComponent() {
        borderContainer.setTop(titleLBL);
        borderContainer.setCenter(gridContainer);
        gridContainer.add(usernameLBL, 0, 1);
        gridContainer.add(passwordLBL, 0, 2);
        gridContainer.add(phoneNumberLBL, 0, 3);
        gridContainer.add(addressLBL, 0, 4);
        gridContainer.add(rolesLBL, 0, 5);
        gridContainer.add(flowContainer, 1, 0);
        gridContainer.add(usernameTXT, 1, 1);
        gridContainer.add(passwordTXT, 1, 2);
        gridContainer.add(phoneNumberTXT, 1, 3);
        gridContainer.add(addressTXT, 1, 4);
        gridContainer.add(buyer, 1, 5);
        gridContainer.add(seller, 1, 6);
        gridContainer.add(admin, 1, 7);
        borderContainer.setBottom(submitBtn);
    }

    void arrangeComponents() {
        usernameTXT.setMinWidth(100);
        passwordTXT.setMinWidth(100);
        addressTXT.setMinWidth(100);
        phoneNumberTXT.setMinWidth(100);

        usernameTXT.setMaxWidth(300);
        passwordTXT.setMaxWidth(300);
        addressTXT.setMaxWidth(300);
        phoneNumberTXT.setMaxWidth(300);

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
    }

    // This method handles toggling of radio buttons and stores the selected role
    public void toggle() {
        group.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle != null) {
                RadioButton selectedRadioButton = (RadioButton) newToggle;
                selectedRole = selectedRadioButton.getText(); // Store the selected role
            }
        });
    }

    public void Register() {
        // Check if the user already exists or not
        String query = "SELECT * FROM users";
        connect.rs = connect.execQuery(query);
        try {
            while (connect.rs.next()) {
                Integer dbuser_id = connect.rs.getInt("user_id");
                String dbusername = connect.rs.getString("username");
                String dbpassword = connect.rs.getString("password");
                String dbphoneNumber = connect.rs.getString("phone_number");
                String dbAddress = connect.rs.getString("address");
                String dbrole = connect.rs.getString("role");
                userList.add(new users(dbuser_id, dbusername, dbpassword, dbphoneNumber, dbAddress, dbrole));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Getting the input values from the form
        String Newusername = usernameTXT.getText();
        String Newpassword = passwordTXT.getText();
        String NewphoneNumber = phoneNumberTXT.getText();
        String NewAddress = addressTXT.getText();
        String Newrole = selectedRole; // Role selected by user

        // Check if the username already exists
        for (users u : userList) {
            if (u.getUsername().equals(Newusername)) {
                // Username already exists, show error alert
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Registration Error");
                alert.setContentText("Username already exists. Please choose another one.");
                alert.showAndWait();
                return; // Stop further processing
            }
        }

        // If username doesn't exist, create a new user
        Integer user_id = userList.size() + 1; // Increment user_id based on existing list size
        users newUser = new users(user_id, Newusername, Newpassword, NewphoneNumber, NewAddress, Newrole);

        // Prepare SQL INSERT query
        String insertQuery = "INSERT INTO users (user_id, username, password, phone_number, address, role) VALUES(?, ?, ?, ?, ?, ?)";
        
        // Use PreparedStatement to safely insert data into the database
        try (PreparedStatement st = connect.prepareStatement(insertQuery)) {
            st.setInt(1, user_id); // Set user_id
            st.setString(2, Newusername); // Set username
            st.setString(3, Newpassword); // Set password
            st.setString(4, NewphoneNumber); // Set phone number
            st.setString(5, NewAddress); // Set address
            st.setString(6, Newrole); // Set role

            // Execute the update to insert the new user into the database
            st.executeUpdate();

            // After successful registration, redirect the user based on their role
            if (newUser.getRole().equalsIgnoreCase("admin")) {
                new HomeSeller(stage, newUser); // Admin-specific page
            } else if (newUser.getRole().equalsIgnoreCase("buyer")) {
                new HomeBuyer(stage, newUser); // Buyer-specific page
            } else if (newUser.getRole().equalsIgnoreCase("seller")) {
                new HomeSeller(stage, newUser); // Seller-specific page
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("An error occurred while registering. Please try again.");
            alert.showAndWait();
        }
    }

    public void initAction() {
        submitBtn.setOnAction(e -> {
            Register();
        });
    }

    public Register(Stage arg0) {
        initialize();
        addComponent();
        arrangeComponents();
        toggle(); 
        initAction();

        this.stage = arg0;
        arg0.setScene(scene);
        arg0.show();
    }
}

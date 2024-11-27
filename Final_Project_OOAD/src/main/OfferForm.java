package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OfferForm {
	Scene scene;
	Label titleLBL, priceLBL;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	TextField priceTXT;
	Button submitBtn;
	RadioButton seller,buyer;
	Stage stage;
	
	
	void initialize() {
		titleLBL = new Label("Offer Form");
		priceLBL = new Label("Price");
		
		
		borderContainer = new BorderPane();
		flowContainer = new FlowPane();
		gridContainer = new GridPane();
	
		
		priceTXT = new TextField();
	
		submitBtn = new Button("Offer");
	
		
		
		scene = new Scene(borderContainer,600,400);
		
	}
	void addComponent() {
		borderContainer.setTop(titleLBL);
		borderContainer.setCenter(gridContainer);
		gridContainer.add(priceLBL, 0, 1);
	
		gridContainer.add(flowContainer, 1, 0);
		gridContainer.add(priceTXT, 1,1);
	
		borderContainer.setBottom(submitBtn);
		
	}
	
	void arrageComponents() {
		
		priceTXT.setMinWidth(100);
	
		priceTXT.setMaxWidth(300);
		
		
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
//	fasfaf
	
//	fafasfaf
	}
	
	public OfferForm(Stage arg0) {
		initialize();
		addComponent();
		arrageComponents();
		 
	        this.stage = arg0;
	        arg0.setScene(scene);
	        arg0.show();
	}
}

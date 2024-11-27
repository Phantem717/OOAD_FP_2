package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DeclineOfferReason {
	Scene scene;
	Label titleLBL, reasonLBL;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	TextField reasonTXT;
	Button submitBtn;
	RadioButton seller,buyer;
	Stage stage;
	
	
	void initialize() {
		titleLBL = new Label("Decline Offer Form");
		reasonLBL = new Label("Reason");
		
		
		borderContainer = new BorderPane();
		flowContainer = new FlowPane();
		gridContainer = new GridPane();
	
		
		reasonTXT = new TextField();
	
		submitBtn = new Button("Deny");
	
		
		
		scene = new Scene(borderContainer,600,400);
		
	}
	void addComponent() {
		borderContainer.setTop(titleLBL);
		borderContainer.setCenter(gridContainer);
		gridContainer.add(reasonLBL, 0, 1);
	
		gridContainer.add(flowContainer, 1, 0);
		gridContainer.add(reasonTXT, 1,1);
	
		borderContainer.setBottom(submitBtn);
		
	}
	
	void arrageComponents() {
		
		reasonTXT.setMinWidth(100);
	
		reasonTXT.setMaxWidth(300);
		
		
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
	
	public DeclineOfferReason(Stage arg0) {
		initialize();
		addComponent();
		arrageComponents();
		 
	        this.stage = arg0;
	        arg0.setScene(scene);
	        arg0.show();
	}
}

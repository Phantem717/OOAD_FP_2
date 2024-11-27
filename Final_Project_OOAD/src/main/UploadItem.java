package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UploadItem {
	Scene scene;
	Label titleLBL,nameLBL,categoryLBL,sizeLBL,priceLBL;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	TextField nameTXT,categoryTXT,sizeTXT,priceTXT;
	
	Button submitBtn;
	Stage stage;
	void initialize() {
		titleLBL = new Label("Upload Item");
		nameLBL = new Label("Item Name");
		categoryLBL = new Label("Category");
		sizeLBL = new Label("Size");
		priceLBL = new Label("Price");

		nameTXT = new TextField();
		categoryTXT = new TextField();
		sizeTXT = new TextField();
		priceTXT = new TextField();

		
		borderContainer = new BorderPane();
		flowContainer = new FlowPane();
		gridContainer = new GridPane();
		
		submitBtn = new Button("Add Item");
		scene = new Scene(borderContainer,600,400);

	}
	
	void addComponent() {
		borderContainer.setTop(titleLBL);
		borderContainer.setCenter(gridContainer);
		gridContainer.add(categoryLBL, 0, 2);
		gridContainer.add(nameLBL, 0, 1);
		gridContainer.add(sizeLBL, 0, 3);
		gridContainer.add(priceLBL, 0, 4);

		
		gridContainer.add(nameTXT, 1, 1);
		gridContainer.add(categoryTXT, 1, 2);
		gridContainer.add(sizeTXT, 1, 3);
		gridContainer.add(priceTXT, 1, 4);
		borderContainer.setBottom(submitBtn);

	}
	
	void arrangeComponents() {
		sizeTXT.setMinWidth(100);
		nameTXT.setMinWidth(100);
		categoryTXT.setMinWidth(100);
		priceTXT.setMinWidth(100);

	
		sizeTXT.setMaxWidth(300);
		nameTXT.setMaxWidth(300);
		priceTXT.setMaxWidth(300);
		categoryTXT.setMaxWidth(300);

		
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
	public UploadItem(Stage arg0) {
		
		initialize();
		addComponent();
		arrangeComponents();
		 
	        this.stage = arg0;
	        arg0.setScene(scene);
	        arg0.show();	
	}

}

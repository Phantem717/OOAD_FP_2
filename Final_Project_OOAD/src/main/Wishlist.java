package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Wishlist {
	private Scene scene;
	private TableView<String> table;
	private GridPane gp;
	Label titleLBL;
	BorderPane borderContainer;

	private Button RemoveBtn;
	private Stage stage;
	private VBox vb;
	
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}
	public void init(){
		table = new TableView<String>();
		gp = new GridPane();

		
		titleLBL = new Label("Requested Items");

		
		RemoveBtn = new Button("Remove");
	
		vb = new VBox();
		
		scene = new Scene(vb, 500, 500);
	}
	public void setLayout() {
		
		
		
	
		gp.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(titleLBL,table, gp, RemoveBtn);
	      HBox buttonBox = new HBox(10,  RemoveBtn); // Add buttons with spacing
	        buttonBox.setAlignment(Pos.CENTER); // Center the buttons
	        vb.getChildren().add(buttonBox);
	}
	public void setTable() {
		TableColumn<String,String> nameCol = new TableColumn<String,String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<String,String>("name"));
		nameCol.setMinWidth(100);

		TableColumn<String,String> categoryCol = new TableColumn<String,String>("Category");
		categoryCol.setCellValueFactory(new PropertyValueFactory<String,String>("category"));
		categoryCol.setMinWidth(100);
		
		TableColumn<String,String>sizeCol = new TableColumn<String,String>("Size");
		sizeCol.setCellValueFactory(new PropertyValueFactory<String,String>("size"));
		sizeCol.setMinWidth(100);
		
		TableColumn<String,String> initpriceCol = new TableColumn<String, String>("Initial Price");
		initpriceCol.setCellValueFactory(new PropertyValueFactory<String, String>("Initialprice"));
		initpriceCol.setMinWidth(100);
		
		TableColumn<String,String> newpriceCol = new TableColumn<String, String>("New Price");
		newpriceCol.setCellValueFactory(new PropertyValueFactory<String, String>("NewPrice"));
		newpriceCol.setMinWidth(100);
        table.getColumns().addAll(nameCol,categoryCol,sizeCol, initpriceCol,newpriceCol);

	}

	
	public Wishlist(Stage arg0) {
		init();
		setLayout();
		setTable();
		
	    this.stage = arg0;
        arg0.setScene(scene);
        arg0.show();
	}
}

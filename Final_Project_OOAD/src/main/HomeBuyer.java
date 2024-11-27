package main;

import Model.users;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeBuyer {
	private Scene scene;
	private TableView<String> table;
	private GridPane gp;
	Label titleLBL,nameLBL,categoryLBL,sizeLBL,priceLBL;
	BorderPane borderContainer;
	TextField nameTXT,categoryTXT,sizeTXT,priceTXT;
	private Button purchaseBtn,makeOfferBtn;
	private Button historyBtn,wishlistBtn;
	private Stage stage;
	private VBox vb;
	private users user;
	public HomeBuyer() {
		// TODO Auto-generated constructor stub
	}
	public void init(){
		table = new TableView<String>();
		gp = new GridPane();
//		nameTXT = new TextField();
//		priceTXT = new TextField();
//		categoryTXT = new TextField();
//		sizeTXT = new TextField();
		
		titleLBL = new Label("Home Buyer");

//		nameLBL = new Label("Name: ");
//		categoryLBL = new Label("Category: ");
//		sizeLBL = new Label("Size: ");
//		priceLBL = new Label("Price: ");
		purchaseBtn = new Button("Purchase");
		makeOfferBtn = new Button("Make Offer");
		historyBtn = new Button("Purchase History");
		wishlistBtn = new Button("Wishlist");
		vb = new VBox();
		
		scene = new Scene(vb, 500, 500);
	}
	public void setLayout() {
	    // Create the header section
	    HBox headerBox = new HBox(10, wishlistBtn, historyBtn);
	    headerBox.setAlignment(Pos.CENTER);

	    // Create the button section
	    HBox buttonBox = new HBox(10, purchaseBtn, makeOfferBtn); 
	    buttonBox.setAlignment(Pos.CENTER);

	    // Set up the grid pane for input fields
//	    gp.add(categoryLBL, 0, 2);
//	    gp.add(nameLBL, 0, 1);
//	    gp.add(sizeLBL, 0, 3);
//	    gp.add(priceLBL, 0, 4);

//	    gp.add(nameTXT, 1, 1);
//	    gp.add(categoryTXT, 1, 2);
//	    gp.add(sizeTXT, 1, 3);
//	    gp.add(priceTXT, 1, 4);
//	    gp.setAlignment(Pos.CENTER);

	    // Add components to the VBox in the correct order
	    vb.setAlignment(Pos.CENTER);
	    vb.getChildren().addAll(
	        titleLBL,      // Title
	        headerBox,     // Header section
	        table,         // Table
	        gp,            // Input fields grid
	        buttonBox      // Buttons section
	    );
	}
	public void initAction() {
		historyBtn.setOnAction(e -> {
			new PurchaseHistory(stage);
		});
		
		wishlistBtn.setOnAction(e ->{
			new Wishlist(stage);
		});
		
		purchaseBtn.setOnAction(e -> {
			new PurchaseHistory(stage);
		});
		
		makeOfferBtn.setOnAction(e ->{
			new OfferForm(stage);
		});
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
		
		TableColumn<String,String> priceCol = new TableColumn<String, String>("Price");
		priceCol.setCellValueFactory(new PropertyValueFactory<String, String>("price"));
		priceCol.setMinWidth(100);
        table.getColumns().addAll(nameCol,categoryCol,sizeCol, priceCol);

	}

	
	public HomeBuyer(Stage arg0,users user) {
		init();
		setLayout();
		setTable();
		initAction();
		this.user = user;
	    this.stage = arg0;
        arg0.setScene(scene);
        arg0.show();
	}
}

package main;

import javafx.application.Application;
import javafx.stage.Stage;
import Util.Connect;
import java.sql.SQLException;




public class Main extends Application{

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
launch(args);

	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		new Register(arg0);
//		new Login(arg0);
//		new UploadItem(arg0);
//		new EditItem(arg0);
//		new HomeSeller(arg0);
//		new HomeBuyer(arg0);
//		new OfferForm(arg0);
//		new RequestedItems(arg0);
//		new DeclineOfferReason(arg0);
//		new OfferedItems(arg0);
//		new Wishlist(arg0);
//		new PurchaseHistory(arg0);
	}

	
}

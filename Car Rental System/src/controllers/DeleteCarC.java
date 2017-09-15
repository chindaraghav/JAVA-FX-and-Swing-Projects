package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Tools.NotifyMe;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mainClass.DeleteCarM;
import model.Cars;
public class DeleteCarC implements Initializable 
{
	public TextField txt1;
	public Button close;
	public boolean ifAvail=false;
	Image i2=new Image("file:close (2).png");
	public void Delete()
	{
		try {
			if(Cars.delCar(txt1.getText()))
			{
				NotifyMe.notifi("Done!","Car Deleted Successfully!",new Image("file:checked.png"));
				txt1.setText(null);
			}
			else
			{
				NotifyMe.notifi("Error!","ID Does Not Exist!",new Image("file:warning.png"));	
			}
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Car Cannot Be Deleted!",new Image("file:warning.png"));	
			
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{	
		close.setGraphic(new ImageView(i2));
	}
	public void closeIt()
	{
		DeleteCarM.W.close();
	}
}

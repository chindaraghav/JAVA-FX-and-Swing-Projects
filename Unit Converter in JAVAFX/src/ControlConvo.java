
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.*;

public class ControlConvo
{
	public TextField f1;
		public TextField f2;
	String a;
	String b;
	public boolean checkPassAndUse(String a,String b)
	{
		if(a.equals("name") && b.equals("pass"))
	     {	return true;  }
		else
		 {	return false; }  
		}
	public void actioN()
	{
		a=f1.getText();
		b=f2.getText();
		if(a.isEmpty()||b.isEmpty())
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Blank!");
			a1.setContentText("You have not Typed Username/Password! Try again..");
			a1.setHeaderText(null);
			a1.showAndWait();
		}
		else{if(checkPassAndUse(a,b))
		{
			Alert a1=new Alert(AlertType.INFORMATION);
			a1.setTitle("Succesfully Logged In!");
			a1.setHeaderText(null);
			a1.setContentText("You Have Succesfully Logged In, Press OK to continue");
			a1.showAndWait();
		}
		else
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("ERROR!");
			
		
			a1.setHeaderText("You Have Typed Either Wrong Username or Password Try Again!");
			a1.setHeaderText(null);
			a1.showAndWait();
		}}
	}
}
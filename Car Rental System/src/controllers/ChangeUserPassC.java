package controllers;
import java.net.URL;
import java.util.ResourceBundle;

import Tools.NotifyMe;
import javafx.animation.ScaleTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import mainClass.*;
import model.*;

public class ChangeUserPassC implements Initializable
{
	
	public Button butt;
	public Button butt1;
	public TextField prevU,prevP,newU,newP;
	public StackPane stackk;
	Image i1=new Image("file:close (2).png");
	Image i2=new Image("file:ok-appproval-acceptance (1).png");
	
	public void close()
	{
		ChangeUserPass.closeIt();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		butt.setGraphic(new ImageView(i2));
		butt1.setGraphic(new ImageView(i1));
		ScaleTransition sc=new ScaleTransition(Duration.seconds(0.3),stackk);
		sc.setFromX(0);
		sc.setFromY(0);
		sc.setToX(1);
		sc.setToY(1);
		sc.play();
	}
	
	public void changeIt()
	{
		if(prevU.getText().equals(null)||prevP.getText().equals(null)||newU.getText().equals(null)||newP.getText().equals(null))
		{
			NotifyMe.notifi("Error","You have to fill all the Fields!",new Image("file:warning.png"));
		}
		else
		{
			try {
				if(DBmain.changeUserAndPass(prevU.getText(),prevP.getText(),newU.getText(),newP.getText()))
				{
					NotifyMe.notifi("Done!","UserName And Password Has Been Successfully Changed", new Image("file:checked.png"));
				}
				else
				{
					NotifyMe.notifi("Error!","Either Your Previous UserName/Password is not correct", new Image("file:warning.png"));
				}
			} catch (Exception e) 
			{
				NotifyMe.notifi("Error!","Operation UnSuccessful Try Again Later", new Image("file:warning.png"));
			}
		}
	}
}

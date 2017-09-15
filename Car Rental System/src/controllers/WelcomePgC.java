package controllers;
import java.net.URL;
import java.util.ResourceBundle;

import Tools.NotifyMe;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainClass.*;
public class WelcomePgC implements Initializable
{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		(new splash()).start();
	}
}
class splash extends Thread
{
	public static Stage ww;
	Image i1=new Image("file:cancel (2).png");
	public void run()
	{
		try 
		{
			Thread.sleep(3000);
			
			Platform.runLater(new Runnable() {

				public void run() 
				{
					try {
						WelcomePg.W.close();
					Parent root=FXMLLoader.load(getClass().getResource("/fxmlDocs/StartPage.fxml"));
					Scene sc=new Scene(root);
					Stage w=new Stage();
					ww=w;
					w.initStyle(StageStyle.UNDECORATED);
					Image i1=new Image("file:icon - Copy.jpg");
					w.getIcons().add(i1);
					w.setScene(sc);
					w.show();
				        }
				catch(Exception e)
				{
					NotifyMe.notifi("Error!","Error While Opening Window!",i1);
				}
				}});
		}
		catch(Exception e)
		{
			System.out.println("didn't work");
		}
	}
}

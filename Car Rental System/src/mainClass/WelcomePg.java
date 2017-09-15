package mainClass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WelcomePg extends Application 
{
	public static Stage W;
	@Override
	public void start(Stage w) throws Exception 
	{
		
		try {
			W=w;
			Image i1=new Image("file:icon - Copy.jpg");
		Parent root=FXMLLoader.load(getClass().getResource("/fxmlDocs/WelcomePage.fxml"));
		Scene sc=new Scene(root);
		w.initStyle(StageStyle.UNDECORATED);
		w.setScene(sc);
		w.getIcons().add(i1);
		w.show();
		    }
		catch(Exception e)
		{
		   System.out.println("Error!");
		}
	}
	public static void main(String[]args)
	{
		launch(args);
	}
}

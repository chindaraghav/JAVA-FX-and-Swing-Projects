package mainClass;

import java.io.IOException;

import Tools.NotifyMe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeleteCarM  
{	
	public static Stage W;
	Image i1=new Image("file:warning.png");
	public DeleteCarM()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/fxmlDocs/DeleteCarW.fxml"));
			Scene sc=new Scene(root);
			w.setScene(sc);
			w.initStyle(StageStyle.TRANSPARENT);
			w.initModality(Modality.APPLICATION_MODAL);
			w.showAndWait();
			
		} catch (IOException e) 
		{
			NotifyMe.notifi("Error","Error While Loading Window!",i1);
		}
	}
}

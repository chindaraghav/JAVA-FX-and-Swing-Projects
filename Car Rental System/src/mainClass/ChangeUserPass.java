package mainClass;

import Tools.NotifyMe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChangeUserPass
{
	Image i1=new Image("file:warning.png");
	public static Stage W;
	
	public ChangeUserPass()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/fxmlDocs/ChangeuserPassW.fxml"));
			Scene sc=new Scene(root);
			w.setScene(sc);
			w.initStyle(StageStyle.UNDECORATED);
			w.initModality(Modality.APPLICATION_MODAL);
			w.showAndWait();
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Error While Opening Window!", i1);
		}
}
	public static void closeIt()
	{
		W.close();
	}
}

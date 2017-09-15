package Tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainCancelC
{
	public static Stage W;
	Image i1=new Image("file:warning.png");
	
	public MainCancelC()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("CancelConfirmationW.fxml"));
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

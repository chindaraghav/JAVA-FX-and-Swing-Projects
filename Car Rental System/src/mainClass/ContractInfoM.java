package mainClass;


import Tools.NotifyMe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ContractInfoM
{
	public static Stage W;
	public ContractInfoM()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/fxmlDocs/InfoW.fxml"));
			Scene sc=new Scene(root);
			w.setScene(sc);
			w.initStyle(StageStyle.TRANSPARENT);
			w.initModality(Modality.APPLICATION_MODAL);
			w.showAndWait();
		} 
		catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("file:warning.png"));
		}
	}
}

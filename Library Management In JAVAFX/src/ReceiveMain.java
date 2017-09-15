import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ReceiveMain 
{
	static Stage W;
	ReceiveMain()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("ReceivePg.fxml"));
			w.setTitle("Update");
		    Scene sc=new Scene(root);
		    w.setResizable(false);
			w.setScene(sc);
			w.show();
		} 
		catch (Exception e) {
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Error Loading Window!");
			a1.showAndWait();
		}
	}
	public static void CloseIt()
	{
		W.close();
	}
}

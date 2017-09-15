import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LibLoginMain 
{
	static Stage W;
	LibLoginMain()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("LibLoginPg.fxml"));
			w.setTitle("Admin Login");
		    Scene sc=new Scene(root);
		    w.setResizable(false);
			w.setScene(sc);
			w.show();
		} 
		catch (Exception e) {
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Error Loading AdminLoginPage!");
			a1.showAndWait();
		}
	}
	public static void CloseIt()
	{
		W.close();
	}
}

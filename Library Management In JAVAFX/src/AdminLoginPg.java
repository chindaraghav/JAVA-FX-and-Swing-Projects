import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AdminLoginPg 
{
	static Stage W;
	AdminLoginPg()
	{
		Stage w=new Stage();
		W=w;
		try {
			Parent root=FXMLLoader.load(getClass().getResource("AdminLoginpg.fxml"));
			w.setTitle("Admin Login");
		    Scene sc=new Scene(root);
			w.setScene(sc);
			w.show();
		} catch (IOException e) {
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
	public static void main(String[] args) {
		new AdminLoginPg();
	}
}

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddBookPg
{
	static Stage W;
	AddBookPg()
	{
		Stage w=new Stage();
		W=w;
		try {
		w.setTitle("Add Books!");
		Parent root=FXMLLoader.load(getClass().getResource("AddBookPg.fxml"));
		Scene sc=new Scene(root);
		w.setResizable(false);
		w.setScene(sc);
		w.showAndWait();
		}
		catch(Exception e)
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Problem While Loading Window!");
			a1.showAndWait();
		}
	}
	public static void closeIt()
	{
		W.close();
	}
}

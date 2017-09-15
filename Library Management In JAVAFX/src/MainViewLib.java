import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainViewLib 
{
	MainViewLib()
	{
		try {
		Stage w=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("ViewLibrarian.fxml"));
		Scene sc=new Scene(root);
		w.setTitle("Librarian Table");
		w.setScene(sc);
		w.showAndWait();
	}
	catch(Exception e)
	{
		alerT.createAlertE("Error","Cannot Load table!");
	}
	}
}

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LibrarianPg 
{
	static Stage W;
	public static void CloseIt()
	{
		W.close();
	}
	LibrarianPg()
	{
		Stage w=new Stage();
		W=w;
		try {
			FXMLLoader fx=new FXMLLoader();
			Parent root=fx.load(getClass().getResource("LibrarianPg.fxml").openStream());
			w.setTitle("Librarian Page");
		    Scene sc=new Scene(root);
		    w.setResizable(false);
			w.setScene(sc);
			w.show();
		} 
		catch (Exception e) {
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Error Loading!");
			a1.showAndWait();
		}
	}
}

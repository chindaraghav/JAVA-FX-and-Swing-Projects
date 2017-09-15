import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainPg extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	static Stage W;
	public void start(Stage w)
	{
		W=w;
		w.setTitle("Login!");
		try {
		Parent root=FXMLLoader.load(getClass().getResource("MainPg.fxml"));
		Scene sc=new Scene(root);
		w.setResizable(false);
		w.setScene(sc);
		w.show();
		}
		catch(Exception e)
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Problem While Loading Login Screen!");
			a1.showAndWait();
		}
	}
	public static void closeIt()
	{
		W.close();
	}
}

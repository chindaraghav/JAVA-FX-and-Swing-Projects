import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alerT 
{
	public static void createAlertE(String title,String cont)
	{
		Alert a1=new Alert(AlertType.ERROR);
		a1.setTitle(title);
		a1.setHeaderText(null);
		a1.setContentText(cont);
		a1.showAndWait();
	}
	public static void createAlertI(String title,String cont)
	{
		Alert a1=new Alert(AlertType.INFORMATION);
		a1.setTitle(title);
		a1.setHeaderText(null);
		a1.setContentText(cont);
		a1.showAndWait();
	}
}

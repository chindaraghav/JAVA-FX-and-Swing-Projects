import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMemberT 
{
	MainMemberT()
	{
		try {
			Stage w=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("MemberShowT.fxml"));
			Scene sc=new Scene(root);
			w.setTitle("Member Information");
			w.setScene(sc);
			w.show();
		} catch (Exception e) {
			alerT.createAlertE("Error!","Cannot Load Table!");
		}
	}
}


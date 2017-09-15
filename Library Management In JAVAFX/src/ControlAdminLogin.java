import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControlAdminLogin 
{
	public ImageView img1;
	public TextField user,pass;
	public Button Login;
	public void initialize()
	{
		Image i1=new Image("file:img1.png");
		img1.setImage(i1);
	}
	public void handle(ActionEvent event)
	{
		if(user.getText().equals("")|| pass.getText().equals(""))
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("UserName/PassWord Field is Empty,Please Type!");
			a1.showAndWait();
		}
		if(user.getText().equals("admin")|| pass.getText().equals("pass"))
		{
			Alert a1=new Alert(AlertType.INFORMATION);
			a1.setTitle("Login Successfull!");
			a1.setHeaderText(null);
			a1.setContentText("You Logged In Successfully!");
			a1.showAndWait();
			new AdminPgMain();
			AdminLoginPg.CloseIt();
		}
	}
}

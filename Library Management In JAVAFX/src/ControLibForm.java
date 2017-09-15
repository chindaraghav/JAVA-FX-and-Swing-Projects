import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControLibForm 
{
	public ImageView img;
	public Button save;
	public TextField id,name,addr,city,phone,email,pass;
	public void initialize()
	{
		Image i1=new Image("file:img3 - Copy.jpg");
		img.setImage(i1);
	}
	public void handle()
	{
		int id1=Integer.valueOf(id.getText());  
		String name1=name.getText();
		String addr1=addr.getText();
		String city1=city.getText();
		String phone1=phone.getText();
		String email1=email.getText();
		String pass1=pass.getText();
		try {
		if(DB.addToLibrarianData(id1, name1, addr1, city1, phone1, email1, pass1))
			{
			Alert a1=new Alert(AlertType.INFORMATION);
			a1.setHeaderText(null);
			a1.setTitle("Successful!");
			a1.setContentText("Librarian is Successfully added");
			a1.show();
			 LibFormMain.closeIt();
			}
		else {
			Alert a1=new Alert(AlertType.ERROR);
			a1.setHeaderText(null);
			a1.setTitle("Failed!");
			a1.setContentText("Librarian can not be Added! Check If Id is not repeated!");
			a1.show();
		;}
		}
		catch(Exception e)
		{
			Alert a1=new Alert(AlertType.ERROR);
			a1.setTitle("Error!");
			a1.setHeaderText(null);
			a1.setContentText("Problem While Loading Login Screen");
			a1.showAndWait();
		}
		}
	}

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class controLibLogin 
{
	public TextField txt1,txt2; 
	public PasswordField txt3;
    static String namea;
	public Button back;
	public ImageView img;
	public static Stage W;
	public void initialize()
	{
		Image i1=new Image("file:img1 - Copy.png");
		img.setImage(i1);
	}
	public void handle()
	{
		int id=Integer.valueOf(txt1.getText());		
		String name=txt2.getText();
		namea=name;
		String pass=txt3.getText();
		try {
		if(DB.ifIdExist(id,"librariandata") && DB.nameExist("librariandata", id, name) && DB.passExist("librariandata", id, pass))
		{		alerT.createAlertI("Login Successfull","You Have Successfully Logged In!");
					LibLoginMain.CloseIt();
					new LibrarianPg();
		}
		else {
			alerT.createAlertE("Error!","Login UnSuccessful!");
		}
	}
		catch(Exception e)
		{
			alerT.createAlertE("Error!","Problem Logging IN!");
		}
		}
	public void back()
	{
		MainPg m1=new MainPg();
		m1.start(new Stage());
		LibLoginMain.CloseIt();
	}
	public static void closeIt()
	{
		W.close();
	}
}

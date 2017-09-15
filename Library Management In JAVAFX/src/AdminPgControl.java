import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AdminPgControl 
{
	public ImageView img;
	public Button add,view,delete,logout;
	public void initialize()
	{
		Image i1=new Image("file:img1.png");
		img.setImage(i1);
	}
	public void add()
	{
		new LibFormMain();
	}
	public void view()
	{
		new MainViewLib();
	}
	public void change()
	{
		
	}
	public void delete()
	{
		new MainDelLib();
	}
	public void logout()
	{
		MainPg c=new MainPg();
		c.start(new Stage());
		AdminPgMain.closeIt();
	}
}

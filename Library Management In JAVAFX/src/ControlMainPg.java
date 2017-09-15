import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControlMainPg 
{
	public ImageView img;
	public void initialize()
	{
		Image i1=new Image("file:img1.png");
		img.setImage(i1);
	}
	public void handle()
	{	
			new AdminLoginPg();
			MainPg.closeIt();
	}
	public void handle2(){
		new LibLoginMain();
		MainPg.closeIt();
	}
}

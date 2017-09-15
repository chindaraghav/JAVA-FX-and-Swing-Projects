import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControlMainPage {
	public ImageView immg;
	public void initialize()
	{
		Image i1=new Image("file:img11.png");
		immg.setImage(i1);
	}
	public void handle(ActionEvent event) throws Exception
	{
		new Main_2();
		MainPage.closeIt();
	}
	public void exit(ActionEvent event)
	{
		MainPage.closeIt();
	}

}

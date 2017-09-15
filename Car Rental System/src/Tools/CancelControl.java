package Tools;

import javafx.scene.image.Image;

public class CancelControl 
{
	public void deleteIt()
	{
		MainCancelC.closeIt();
		NotifyMe.notifi("Done!","Contract Successfully Cancelled", new Image("file:checked.png"));
	}
	public void cancel()
	{
		MainCancelC.closeIt();
	}
}

package Tools;
import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class NotifyMe
{
	public static void notifi(String title,String Text,Image img )
	{
		Notifications n1=Notifications.create()
		.title(title)
		.text(Text)
		.graphic(null)
		.graphic(new ImageView(img))
		.hideAfter(Duration.seconds(3))
		.position(Pos.BOTTOM_RIGHT);
		n1.darkStyle();
		n1.show();
	}
}

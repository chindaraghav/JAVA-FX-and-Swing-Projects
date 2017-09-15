import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainCur {
	static Stage W;
	public MainCur() throws IOException
	{
	Stage w=new Stage();
	W=w;
	Parent root=FXMLLoader.load(getClass().getResource("currency.fxml"));
	Scene sc1=new Scene(root);
	Image i2=new Image("file:unnamed.png");
	w.getIcons().add(i2);
	w.setTitle("Currency");
	w.setResizable(false);
	w.setScene(sc1);
	w.show();
	}
	public static void closeIt()
	{
		W.close();
	}
}

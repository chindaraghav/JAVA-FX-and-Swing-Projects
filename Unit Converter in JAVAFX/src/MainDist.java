import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainDist {

	static Stage W;
	MainDist() throws IOException
{
		Stage w=new Stage();
		W=w;
		w.setTitle("Distance");
	Parent root=FXMLLoader.load(getClass().getResource("dist.fxml"));
	Image i1=new Image("file:unnamed.png");
	w.getIcons().add(i1);
	Scene sc=new Scene(root);
	w.setResizable(false);
	w.setScene(sc);
	w.show();
}
	public static void close_It()
	{
		W.close();
	}
}

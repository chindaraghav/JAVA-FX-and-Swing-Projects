import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainW {
	public static Stage W;
	public MainW() throws IOException
	{
		Stage w=new Stage();
		W=w;
		Parent root=FXMLLoader.load(getClass().getResource("weightpg.fxml"));
		Scene sc=new Scene(root);
	    Image i1=new Image("file:unnamed.png");
	    w.getIcons().add(i1);
	    w.setResizable(false);
		w.setScene(sc);
		w.show();
		
	}
	public static void closeIt()
	{
		W.close();
	}
}

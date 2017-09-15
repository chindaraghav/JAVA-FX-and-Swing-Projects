	import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main_2{
		
		static Stage W;
		public Main_2() throws Exception
		{
			Stage w=new Stage();
			W=w;
		    w.setTitle("Select!");
		    Parent root=FXMLLoader.load(getClass().getResource("Choose.fxml"));
		    Scene sc=new Scene(root);
		    Image i1=new Image("file:unnamed.png");
		    w.getIcons().add(i1);
		    w.setResizable(false);
		    w.setScene(sc);
		    w.show();
		}
		public static void closseIt()
		{
			W.close();
		}
}

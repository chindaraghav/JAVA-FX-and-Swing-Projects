import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Stage;
import java.awt.event.*;
public class Main   {

	Main() throws Exception {
	    Stage w=new Stage();
	     Parent root=FXMLLoader.load(getClass().getResource("ConvoGraphics.fxml"));	
	     Scene sc=new Scene(root);
	     w.setScene(sc);
	     Image i1=new Image("file:images.jpg");
	     w.getIcons().add(i1);
	     w.setTitle("Login Please!");
	     w.show();
	     w.setResizable(false);
	}
}

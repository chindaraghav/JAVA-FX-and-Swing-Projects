import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainPage extends Application{
	static Stage W;
	public static void main(String []args)
	{
		launch(args);
	}
	public void start(Stage w) throws IOException
	{
		W=w;
		w.setTitle("Welcome!");
		Image i1=new Image("file:unnamed.png");
		w.getIcons().add(i1);
		Parent root=FXMLLoader.load(getClass().getResource("HOMEgrp.fxml"));
		Scene sc=new Scene(root);
		w.setResizable(false);
		w.setScene(sc);
		w.show();
	}
	public static void closeIt()
	{
		W.close();
	}
}

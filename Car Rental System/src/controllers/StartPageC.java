package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import mainClass.ChangeUserPass;
import model.DBmain;
import Tools.*;
import mainClass.*;

public class StartPageC implements Initializable
{
	 public StackPane test1;
	 public Button but1;
	 public TextField user,pass;
	 Image i1=new Image("file:cancel (2).png");
	 Image i2=new Image("file:checked.png");
	 Image i3=new Image("file:close (2).png");
	public void initialize(URL location, ResourceBundle resources) 
	{
		FadeTransition fade=new FadeTransition(Duration.seconds(3),test1);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play();
		but1.setGraphic(new ImageView(i3));
	}
	public void handle()
	{
		Platform.exit();
	}
	public void login() throws Exception
	{
		if(user.getText().equals(null)|| pass.getText().equals(null))
		{
			NotifyMe.notifi("Error!","     UserName/PassWord Field is Empty",i2);
		}
		else {
		if(DBmain.checkLogin(user.getText(),pass.getText()))
		{
			NotifyMe.notifi(null,"    Login successful,Welcome",i2); 
			AnchorPane root=FXMLLoader.load(getClass().getResource("/fxmlDocs/AdminW.fxml"));
			FadeTransition fd=new FadeTransition(Duration.seconds(2),test1);
			fd.setFromValue(1);
			fd.setToValue(0);
			fd.play();
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		}
		else 
		{
			NotifyMe.notifi("Error!","    Login Unsuccessful!Try Again.",i1);
		}
		}
	}
	public void newUserPass()
	{
		new ChangeUserPass();
	}
}

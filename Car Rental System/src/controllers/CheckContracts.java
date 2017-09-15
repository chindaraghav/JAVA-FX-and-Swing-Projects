package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Tools.NotifyMe;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.Contracts;

public class CheckContracts implements Initializable
{
	 public AnchorPane root;
	 public Button chk,open;
	 public static Stage WW;
	 public TextField cname,cid,pno;
	 public Label checkla,openla;
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		FadeTransition fd=new FadeTransition(Duration.seconds(2),root);
		fd.setFromValue(0);
		fd.setToValue(1);
		fd.play();
		open.setVisible(false);
		openla.setVisible(false);
	}
	public void goHome()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/AdminW.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);	
		} 
		catch (IOException e) 
		{
			NotifyMe.notifi("Error!","     UserName/PassWord Field is Empty",new Image("file:warning.png"));
		}
	}
	public void goOut()
	{
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/StartPage.fxml"));

			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Cannot Load Window!",new Image("file:warning.png"));
		}
	}
	public void closeIt()
	{
		Platform.exit();
	}
	public void addCarr()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/addNewCar.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("file:warning.png"));
		}
	}
	
	public void checkIt()
	{
		
		if(cname.getText().isEmpty()||cid.getText().isEmpty()||pno.getText().isEmpty())
		{
			NotifyMe.notifi("Not Found!","Contract Is Not Available!",new Image("file:warning.png"));	
		}
		else
		{
			try {
				if(Contracts.checkContract(cid.getText(),cname.getText(),pno.getText()))
				{
                 NotifyMe.notifi("Match!","Contract Found!",new Image("file:checked.png"));
                 chk.setVisible(false);
                 open.setVisible(true);
                 checkla.setVisible(false);
                 openla.setVisible(true);
                 cid.setEditable(false);
                 cname.setEditable(false);
                 pno.setEditable(false);
				}
        else
        {
               NotifyMe.notifi("Not Found!","Contract Is Not Available!",new Image("file:warning.png"));	
        }
			} 
			catch (Exception e) 
			{
				NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("file:warning.png"));
			}
}
		}
	public void OpenIt()
	{
		AnchorPane root;
		try 
		{
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxmlDocs/InfoW.fxml"));
			root=loader.load();
			InfoC controller=loader.getController();
			controller.showData(cid.getText());
			Stage ww=new Stage();
			ww.initStyle(StageStyle.UNDECORATED);
			ww.initModality(Modality.APPLICATION_MODAL);
			Scene sc=new Scene(root);
			ww.setScene(sc);
			ww.showAndWait();
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("file:warning.png"));
		}
	}
	public void refresh()
	{
		 chk.setVisible(true);
         open.setVisible(false);
         checkla.setVisible(true);
         openla.setVisible(false);
         cid.setEditable(true);
         cname.setEditable(true);
         pno.setEditable(true);
         cid.setText(null);
         cname.setText(null);
         pno.setText(null);
	}
}

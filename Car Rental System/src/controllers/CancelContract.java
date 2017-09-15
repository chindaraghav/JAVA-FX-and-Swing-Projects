package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Tools.MainCancelC;
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
import javafx.util.Duration;
import model.Contracts;

public class CancelContract implements Initializable
{
	 public AnchorPane root;
	 public Button chk,del;
	 public Label della,checkla;
	 public TextField cname,cid,phone;
     String ci;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		FadeTransition fd=new FadeTransition(Duration.seconds(2),root);
		fd.setFromValue(0);
		fd.setToValue(1);
		fd.play();
		del.setVisible(false);
		della.setVisible(false);
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
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("warning.png"));
		}
	}
	
	public void checkContro()
	{
		try {

			if(cname.getText().isEmpty()||cid.getText().isEmpty()||phone.getText().isEmpty())
			{
				NotifyMe.notifi("Not Found!","Contract Is Not Available!",new Image("file:warning.png"));	

			}else {
			if(Contracts.checkContract(cid.getText(),cname.getText(),phone.getText()))
					{
				NotifyMe.notifi("Match!","Contract Found!",new Image("file:checked.png"));
				chk.setVisible(false);
				del.setVisible(true);
				checkla.setVisible(false);
				della.setVisible(true);
				cid.setEditable(false);
					}
			else
			{
				NotifyMe.notifi("Not Found!","Contract Is Not Available!",new Image("file:warning.png"));	
			}
			}
		} catch (Exception e) {
			NotifyMe.notifi("Error!","Error While Checking Contract!",new Image("file:warning.png"));
		}
	}
	public void deleteIt()
	{
		try {
			if(Contracts.deleteContr(cid.getText()))
			{
				NotifyMe.notifi("Done","Contract Deleted Successfully!", new Image("file:checked.png"));
			}
			else
			{
				NotifyMe.notifi("UnSuccessful!","Contract Cannot Be Deleted!", new Image("file:warning.png"));	
			}
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Error While Deleting Contract!",new Image("file:warning.png"));
		}
	}
public void refresh()
{
	chk.setVisible(true);
	checkla.setVisible(true);
	del.setVisible(false);
	della.setVisible(false);
	cid.setEditable(true);
	cid.setText(null);
	cname.setText(null);
	phone.setText(null);
}
}

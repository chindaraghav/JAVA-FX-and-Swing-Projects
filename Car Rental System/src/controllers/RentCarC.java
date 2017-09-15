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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.Contracts;
import model.DBmain;

public class RentCarC implements Initializable
{
	public Button exit,sigout,home,add,refresh,submit;
	public TextField namet,fnamet,pno,addr,dest,km,cname,tfare,afare,cid;
	public DatePicker d2,d1,d;
	public CheckBox driv,acard,passport,other;
	public AnchorPane roo;
	Image i2=new Image("file:exit.png");
	Image i3=new Image("file:sign-out-option.png");
	Image i4=new Image("file:home-button-for-interface.png");
	Image i5=new Image("file:car_2-add-64.png");
	Image i6=new Image("file:refresh-button.png");
	Image i7=new Image("file:ok-appproval-acceptance128.png");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		exit.setGraphic(new ImageView(i2));
		sigout.setGraphic(new ImageView(i3));
		home.setGraphic(new ImageView(i4));
		add.setGraphic(new ImageView(i5));
		refresh.setGraphic(new ImageView(i6));
		submit.setGraphic(new ImageView(i7));
		
		FadeTransition fd=new FadeTransition(Duration.seconds(3),roo);
	    fd.setFromValue(0);
	    fd.setToValue(1);
	    fd.play();
	}	
	public void closeIt()
	{
		Platform.exit();
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
			NotifyMe.notifi("Error!","     UserName/PassWord Field is Empty",i7);
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
	public void Refresh()
	{
		namet.setText(null);
		fnamet.setText(null);
		pno.setText(null);
		addr.setText(null);
		dest.setText(null);
		km.setText(null);
		cname.setText(null);
		tfare.setText(null);
		afare.setText(null);
		cid.setText(null);
		d1.setValue(null);
		d2.setValue(null);
		d.setValue(null);
		driv.setSelected(false);;
		acard.setSelected(false);;
		passport.setSelected(false);;
		other.setSelected(false);
		
	}
	public void Submit()
	{
		try {
			if(notNull())
			{
				NotifyMe.notifi("Error!","Please Fill All The Fields!",new Image("file:warning.png"));
			}
			else
			{
				if(Contracts.addContract(cid.getText(),namet.getText(), fnamet.getText(), pno.getText(),addr.getText(), dest.getText(), km.getText(),d1.getValue().toString(),d2.getValue().toString(),cname.getText(), tfare.getText(), afare.getText(),Document(), d.getValue().toString()))
			{			
				NotifyMe.notifi("Done!","Contract Added Successfully!",new Image("file:checked.png"));
			}
			else
			{
				NotifyMe.notifi("Error!","Cannot Add Contract!",new Image("file:warning.png"));

			}
			}

		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Cannot Add Contract!",new Image("file:warning.png"));
		}
	}
	public void Exit()
	{
		Platform.exit();
	}
	public String Document()
	{
		String total="";
		if(driv.isSelected())
		{
			total=total+","+driv.getText();
		}
		if(acard.isSelected())
		{
			total=total+","+acard.getText();
		}
		if(passport.isSelected())
		{
			total=total+","+passport.getText();
		}
		if(other.isSelected())
		{
			total=total+","+other.getText();
		}
		return total;
	}
	public boolean notNull()
	{
		if(namet.getText().isEmpty()||fnamet.getText().isEmpty()||pno.getText().isEmpty()||addr.getText().isEmpty()
				||dest.getText().isEmpty()||km.getText().isEmpty()||cname.getText().isEmpty()
				||tfare.getText().isEmpty()||afare.getText().isEmpty()||cid.getText().isEmpty()||d.getValue().toString().isEmpty()
				||d1.getValue().toString().isEmpty()||d2.getValue().toString().isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}

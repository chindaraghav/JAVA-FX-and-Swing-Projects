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
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import mainClass.ContractInfoM;

public class AdminPageC implements Initializable
{
	public AnchorPane panee;
	public Button but,add,rent,avail,contrac,del,exit;
	Image i1=new Image("file:close (2).png");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		but.setGraphic(new ImageView(i1));
		but.setTooltip(new Tooltip("Close"));
		add.setTooltip(new Tooltip("Add New Car"));
		rent.setTooltip(new Tooltip("Rent Car"));
		avail.setTooltip(new Tooltip("Check Availability"));
		contrac.setTooltip(new Tooltip("View Contracts"));
		del.setTooltip(new Tooltip("Cancel Contract"));
		exit.setTooltip(new Tooltip("EXIT!"));
	}
	public void close()
	{
		Platform.exit();
	}
	public void add()
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
	public void delete()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/cancelContractW.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("file:warning.png"));
		}	
	}
	public void rent()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/RentCarW.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("warning.png"));
		}
	}
	public void avail()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/Contract.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("warning.png"));
		}
	}
	public void contrac()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/CheckContractsW.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);
		} catch (Exception e) 
		{
			NotifyMe.notifi("Error!","ERROR WHILE OPENING WINDOW!",new Image("warning.png"));
		}
	}
	
	
}

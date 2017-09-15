package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Tools.NotifyMe;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import mainClass.DeleteCarM;
import model.Cars;
import model.DBmain;
import model.about_Car;;

public class AddCarC implements Initializable
{
	
	public Button submit,cll,signout,home,search,delcar;
	Image i1=new Image("file:ok-appproval-acceptance (1).png");
	Image i2=new Image("file:close (2).png");
	Image i3=new Image("file:home-button-for-interface.png");
	Image i4=new Image("file:sign-out-option.png");
	Image i5=new Image("file:magnifier.png");
	Image i6=new Image("file:delcar.png");
	 Image i7=new Image("file:cancel (2).png");
	public AnchorPane ro;
	public TextField model,chassis,plate,dents,carid,searchbox;
	public DatePicker year,date;
	public ComboBox<String> overall;
    
	public TableView<about_Car> table;
	public TableColumn<about_Car,String> md;
	public TableColumn<about_Car,String> cha;
	public TableColumn<about_Car,String> plt;
	public TableColumn<about_Car,String> yr;
	public TableColumn<about_Car,String> dt;
	public TableColumn<about_Car,String> dnt;
	public TableColumn<about_Car,String> cond;
	public TableColumn<about_Car,String> id;
	public ObservableList<about_Car> list;
	@Override	
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		refreshTable();
		overall.getItems().addAll("Excellent","Good","Bad");
		cll.setGraphic(new ImageView(i2));
		submit.setGraphic(new ImageView(i1));
		signout.setGraphic(new ImageView(i4));
		home.setGraphic(new ImageView(i3));
		search.setGraphic(new ImageView(i5));
		delcar.setGraphic(new ImageView(i6));
		FadeTransition fd=new FadeTransition(Duration.seconds(3),ro);
	    fd.setFromValue(0);
    	fd.setToValue(1);
	    fd.play();
	}
	
	public void close()
	{
		Platform.exit();
	}
	public void Delete()
	{
		new DeleteCarM();
	}
	public void goHome()
	{
		AnchorPane root;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxmlDocs/AdminW.fxml"));
			Scene sc=new Scene(root);
			splash.ww.setScene(sc);	
		} catch (IOException e) 
		{
			NotifyMe.notifi("Error!","     UserName/PassWord Field is Empty",i7);
		}
		
	}
	public void logout()
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
	public void add()
	{
		try {
			if(carid.getText().isEmpty()||model.getText().isEmpty()||plate.getText().isEmpty()||year.getValue().toString().isEmpty()||date.getValue().toString().isEmpty()||dents.getText().isEmpty()||chassis.getText().isEmpty())
			{
				NotifyMe.notifi("Error!","Please Fill All The Fields!",new Image("file:warning.png"));
			}
			else
			{
			if(Cars.addCar(carid.getText(),model.getText(),plate.getText(),year.getValue().toString(),date.getValue().toString(),dents.getText(),overall.getValue().toString(),chassis.getText()))
			{
				NotifyMe.notifi("Done!","Operation Successfull! Car Has Been Added Successfully!", new Image("file:checked.png"));
				refreshTable();
			}
			else {
				NotifyMe.notifi("Error!","Duplicate Records Not Allowed!",new Image("file:warning.png"));

			}
		}
			} 
			catch (Exception e) 
		{
			NotifyMe.notifi("Error!","Error While Saving The Car!",new Image("file:warning.png"));
		}
		
	}
	public void refresh()
	{
		carid.setText(null);
		model.setText(null);
		plate.setText(null);
		year.setValue(null);
		date.setValue(null);
		dents.setText(null);
		chassis.setText(null);
		refreshTable();
	}
	public void refreshTable()
	{
		list=FXCollections.observableArrayList();
		md.setCellValueFactory(new PropertyValueFactory<about_Car,String>("model"));
		cha.setCellValueFactory(new PropertyValueFactory<about_Car,String>("chassis"));
		plt.setCellValueFactory(new PropertyValueFactory<about_Car,String>("plate"));
		yr.setCellValueFactory(new PropertyValueFactory<about_Car,String>("year"));
		dt.setCellValueFactory(new PropertyValueFactory<about_Car,String>("date"));
		dnt.setCellValueFactory(new PropertyValueFactory<about_Car,String>("dents"));
		cond.setCellValueFactory(new PropertyValueFactory<about_Car,String>("condition"));
		id.setCellValueFactory(new PropertyValueFactory<about_Car,String>("carid"));
		
		try {
			Connection sc=DBmain.connect();
			String query="select * from cars";
			Statement st=sc.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				list.add(new about_Car(
						rs.getString("model"),
						rs.getString("chassis"),
						rs.getString("plate"),
						rs.getString("year"),
						rs.getString("date"),
						rs.getString("dents"),
						rs.getString("overall"),
						rs.getString("carID")
						));
			}
			sc.close();
			table.setItems(list);
		}
		catch(Exception e)
		{
			NotifyMe.notifi("Error!","Cannot Load table!", new Image("file:warning.png"));
		}
	}
	public void search()
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

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import model.DBmain;
import model.about_Contract;
import model.about_Contract;

public class ContractC implements Initializable
{
	 public AnchorPane root;
	 public TableView<about_Contract> table;
		public TableColumn<about_Contract,String> name;
		public TableColumn<about_Contract,String> fname;
		public TableColumn<about_Contract,String> pno;
		public TableColumn<about_Contract,String> addr;
		public TableColumn<about_Contract,String> desti;
		public TableColumn<about_Contract,String> kms;
		public TableColumn<about_Contract,String> from;
		public TableColumn<about_Contract,String> to;
		public TableColumn<about_Contract,String> fare;
		public TableColumn<about_Contract,String> adv;
		public TableColumn<about_Contract,String> doc;
		public TableColumn<about_Contract,String> carid;
		public TableColumn<about_Contract,String> date;
		public TableColumn<about_Contract,String> cid;
		public ObservableList<about_Contract> list;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		FadeTransition fd=new FadeTransition(Duration.seconds(2),root);
		fd.setFromValue(0);
		fd.setToValue(1);
		fd.play();
		refreshTable();
		
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
	public void refresh()
	{
		
	}
	public void refreshTable()
	{
		list=FXCollections.observableArrayList();
		name.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("name"));
		fname.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("fathername"));
		pno.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("phone"));
		addr.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("address"));
		desti.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("destination"));
		kms.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("kms"));
		from.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("from"));
		to.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("to"));
		fare.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("fare"));
		adv.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("advance"));
		doc.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("document"));
		carid.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("carid"));
		date.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("date"));
		cid.setCellValueFactory(new PropertyValueFactory<about_Contract,String>("customerid"));
		try {
			Connection sc=DBmain.connect();
			String query="select * from Rent";
			Statement st=sc.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				list.add(new about_Contract(
						rs.getString("name"),
						rs.getString("fathername"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("destination"),
						rs.getString("kms"),
						rs.getString("from"),
						rs.getString("to"),
						rs.getString("car"),
						rs.getString("fare"),
						rs.getString("advance"),
						rs.getString("document"),
						rs.getString("Date"),
						rs.getString("customerid")
						));
			}
			table.setItems(list);
		}
		catch(Exception e)
		{
			NotifyMe.notifi("Error!","Cannot Load table!", new Image("file:warning.png"));
		}
	}
}

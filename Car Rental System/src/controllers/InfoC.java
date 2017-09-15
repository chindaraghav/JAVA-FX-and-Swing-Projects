package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


import Tools.NotifyMe;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DBmain;

public class InfoC
{
	public static Stage W;
	String ID;
	public Label name,fname,phone,addr,destination,kms,fdate,tdate,carname,tfare,adv,doc,cidd,pdate;
	public void showData(String ID) 
	{	
 		Connection cn;
		try {
			cn = DBmain.connect();
			String query="select * from Rent where customerid=11";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(query);
			cidd.setText(rs.getString("customerid"));
		    name.setText(rs.getString("name"));
		    fname.setText(rs.getString("fathername"));
		    phone.setText(rs.getString("phone"));
		    addr.setText(rs.getString("address"));
		    destination.setText(rs.getString("destination"));
		    kms.setText(rs.getString("kms"));
		    fdate.setText(rs.getString("from"));
		    tdate.setText(rs.getString("to"));
		    carname.setText(rs.getString("car"));
		    tfare.setText(rs.getString("fare"));
		    adv.setText(rs.getString("advance"));
		    doc.setText(rs.getString("document")); 
		    pdate.setText(rs.getString("Date"));  
		    cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void closeIt()
	{
	CheckContracts.WW.close();	
	}
}

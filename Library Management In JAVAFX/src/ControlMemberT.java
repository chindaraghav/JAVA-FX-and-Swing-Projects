import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControlMemberT 
{
	public TableView<About_Member> table;
	public TableColumn<About_Member,String> idt;
	public TableColumn<About_Member,String> namet;
	public TableColumn<About_Member,String> fnamet;
	public TableColumn<About_Member,String> phonet;
	public TableColumn<About_Member,String> emailt;
	public TableColumn<About_Member,String> addresst;
	public ObservableList<About_Member> list;
	public void initialize()
	{
		list=FXCollections.observableArrayList();
		idt.setCellValueFactory(new PropertyValueFactory<About_Member,String>("id"));
		namet.setCellValueFactory(new PropertyValueFactory<About_Member,String>("name"));
		fnamet.setCellValueFactory(new PropertyValueFactory<About_Member,String>("fathername"));
		phonet.setCellValueFactory(new PropertyValueFactory<About_Member,String>("phone"));
		emailt.setCellValueFactory(new PropertyValueFactory<About_Member,String>("email"));
		addresst.setCellValueFactory(new PropertyValueFactory<About_Member,String>("address"));
		
		try {
		Connection sc=DB.connect();
		String query="select * from memberdata";
		Statement st=sc.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			list.add(new About_Member(
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("fathername"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("address")
					));
		}
		table.setItems(list);
		}
		catch(Exception e)
		{
			alerT.createAlertE("Error!","Cannot Load Member Table!");
		}
	}
}

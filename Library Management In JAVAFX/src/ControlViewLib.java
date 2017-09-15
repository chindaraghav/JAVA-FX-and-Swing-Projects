import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControlViewLib 
{
	public TableView<Librarian_getset> table;
	public TableColumn<Librarian_getset,Integer> idt;
	public TableColumn<Librarian_getset,String> namet;
	public TableColumn<Librarian_getset,String> addresst;
	public TableColumn<Librarian_getset,String> cityt;
	public TableColumn<Librarian_getset,String> phonet;
	public TableColumn<Librarian_getset,String> emailt;
	public TableColumn<Librarian_getset,String> passt;
	public ObservableList<Librarian_getset> list;
	public void showData()
	{
		try {
			idt.setCellValueFactory(new PropertyValueFactory<Librarian_getset,Integer>("id"));
			namet.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("name"));
			addresst.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("address"));
			cityt.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("city"));
			phonet.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("phone"));
			emailt.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("email"));
			passt.setCellValueFactory(new PropertyValueFactory<Librarian_getset,String>("pass"));
		list=FXCollections.observableArrayList();
		Connection cn=DB.connect();
		String query="select * from librariandata";
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			list.add(new Librarian_getset(rs.getInt("id"),
					rs.getString("name"),
					rs.getString("address"),
					rs.getString("city"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("password")));
		}
		table.setItems(list);
		}
		catch(Exception e)
		{
			alerT.createAlertE("Error","Cannot Load DataBase!");
		}
	}
}

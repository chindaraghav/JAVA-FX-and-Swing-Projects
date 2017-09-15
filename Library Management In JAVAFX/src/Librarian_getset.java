import javafx.beans.property.*;

public class Librarian_getset 
{
	public SimpleIntegerProperty id;
	public SimpleStringProperty name,address,city,phone,email,pass;
	public Librarian_getset(int id, String name, String address, String city, String phone, String email, String pass) {
		super();
		this.id =new SimpleIntegerProperty(id);
		this.name =new SimpleStringProperty (name);
		this.address =new SimpleStringProperty (address);
		this.city =new SimpleStringProperty (city);
		this.phone =new SimpleStringProperty (phone);
		this.email =new SimpleStringProperty (email);
		this.pass =new SimpleStringProperty (pass);
	}
	public int getId() {
		return id.get();
	}
	public String getName() {
		return name.get();
	}
	public String getAddress() {
		return address.get();
	}
	public String getCity() {
		return city.get();
	}
	public String getPhone() {
		return phone.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getPass() {
		return pass.get();
	}
	
}

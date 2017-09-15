import javafx.beans.property.SimpleStringProperty;

public class About_Member 
{
	public SimpleStringProperty id,name,fathername,phone,email,address;

	public String getId() {
		return id.get();
	}

	public String getName() {
		return name.get();
	}

	public String getFathername() {
		return fathername.get();
	}

	public String getPhone() {
		return phone.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getAddress() {
		return address.get();
	}

	public About_Member(String id, String name, String fathername, String phone, String email, String address) {
		super();
		this.id =new SimpleStringProperty (id);
		this.name =new SimpleStringProperty(name);
		this.fathername =new SimpleStringProperty(fathername);
		this.phone =new SimpleStringProperty(phone);
		this.email =new SimpleStringProperty(email);
		this.address =new SimpleStringProperty(address);
	}
}

package model;

import javafx.beans.property.SimpleStringProperty;

public class about_Contract 
{
	public SimpleStringProperty customerid,name,fathername,phone,address,destination,kms,from,to,fare,advance
	,document,date,carid;

	public String getCustomerid() {
		return customerid.get();
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

	public String getAddress() {
		return address.get();
	}

	public String getDestination() {
		return destination.get();
	}

	public about_Contract(String name, String fathername, String phone, String address,
			String destination, String kms, String from, String to, String carid, String fare, String advance,
			String document, String date,String customerid) {
		super();
		this.customerid =new SimpleStringProperty(customerid);
		this.name = new SimpleStringProperty(name);
		this.fathername =new SimpleStringProperty(fathername);
		this.phone =new SimpleStringProperty(phone);
		this.address =new SimpleStringProperty(address);
		this.destination = new SimpleStringProperty(destination);
		this.kms = new SimpleStringProperty(kms);
		this.from = new SimpleStringProperty(from);
		this.to = new SimpleStringProperty(to);
		this.carid = new SimpleStringProperty(carid);
		this.fare = new SimpleStringProperty(fare);
		this.advance = new SimpleStringProperty(advance);
		this.document = new SimpleStringProperty(document);
		this.date = new SimpleStringProperty(date);
	}

	public String getKms() {
		return kms.get();
	}

	public String getFrom() {
		return from.get();
	}

	public String getTo() {
		return to.get();
	}

	public String getCarid() {
		return carid.get();
	}

	public String getFare() {
		return fare.get();
	}

	public String getAdvance() {
		return advance.get();
	}

	public String getDocument() {
		return document.get();
	}

	public String getDate() {
		return date.get();
	}
}

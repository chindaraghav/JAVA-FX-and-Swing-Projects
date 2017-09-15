package model;

import javafx.beans.property.SimpleStringProperty;

public class about_Car 
{
	public SimpleStringProperty carid,model,chassis,plate,year,date,condition;
	public SimpleStringProperty dents;
	
	public about_Car(String model, String chassis, String plate, String year, String date, String dents,String condition,String carid) {
		super();
		this.carid = new SimpleStringProperty (carid);
		this.model = new SimpleStringProperty (model);
		this.chassis = new SimpleStringProperty (chassis);
		this.plate = new SimpleStringProperty (plate);
		this.year = new SimpleStringProperty (year);
		this.date = new SimpleStringProperty (date);
		this.dents = new SimpleStringProperty (dents);
		this.condition =new SimpleStringProperty (condition);
	}
	public String getCarid() {
		return carid.get();
	}
	public String getModel() {
		return model.get();
	}
	public String getChassis() {
		return chassis.get();
	}
	public String getPlate() {
		return plate.get();
	}
	public String getYear() {
		return year.get();
	}
	public String getDate() {
		return date.get();
	}
	public String getDents() {
		return dents.get();
	}
	public String getCondition() {
		return condition.get();
	}

	
}

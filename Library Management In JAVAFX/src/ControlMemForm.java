import javafx.scene.control.TextField;

public class ControlMemForm 
{
	public TextField name,fname,address,email,phone,id;
	public void handle()
	{
		try {
		String name1=name.getText();
		String fname1=fname.getText();
		String address1=address.getText();
		String email1=email.getText();
		String phone1=phone.getText();
		String id1=id.getText();
		if(DB.addNewMember(id1, name1, fname1, phone1, email1, address1))
		{
			alerT.createAlertI("Operation Successful!","Member is Succesfully Added!");
			 name.setText(null);
			 fname.setText(null);
			 address.setText(null);
			 email.setText(null);
			 phone.setText(null);
			 id.setText(null);;
		}
		else
		{
			alerT.createAlertE("Error!","Cannot Add Member please Check Information Again!");
		}
		}
		catch(Exception e)
		{
			alerT.createAlertE("Error!","Cannot Add Data!");
		}
	}
}

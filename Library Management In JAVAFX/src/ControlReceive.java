import javafx.scene.control.TextField;

public class ControlReceive 
{
	public TextField bookid,memid;
	
	public void handle()
	{
		try {
			
		String bookid1=bookid.getText();
		String memid1=memid.getText();
		if(DB.updateStatus(bookid1,memid1))
		{
			alerT.createAlertI("Operation Successful!","Data Updated Successfully!");
			bookid.setText(null);
		   memid.setText(null);
		}
		else
		{
			alerT.createAlertE("Error","Could Not Update! Please Check Data And Try Again!");
		}
		}
		catch(Exception e)
		{
			alerT.createAlertE("Error!","Cannot Update!");
		}
	}
}

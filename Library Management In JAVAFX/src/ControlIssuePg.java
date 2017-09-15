import javafx.scene.control.TextField;

public class ControlIssuePg 
{
	public TextField memid,name,bookid;
    public void handle()
    {
    	try {
    	String mid=memid.getText();
    	String bname=name.getText();
    	String bookid1=bookid.getText();
    	
    	if(DB.issueBook(mid, bname, bookid1))
    	{
    		alerT.createAlertI("Operation SuccessFul","Book Issued Successfully!");
    		memid.setText(null);
    		name.setText(null);
    		bookid.setText(null);
    	}
    	else
    	{
    		alerT.createAlertE("Error","Unable To Add Book! Check your Book-Id And Member-Id.");
    	}
    	}
    	catch(Exception e)
    	{
    		alerT.createAlertE("Error","Error While Issuing Book!");
    	}
    }
}

import javafx.scene.control.TextField;

public class ControlAddBook 
{
	public TextField mm,dd,yy,name,id;
	public static boolean checkDate(String dd,String mm,String yy)
	{
		int date=Integer.valueOf(dd); 
		int month=Integer.valueOf(mm); 
		int year=Integer.valueOf(yy);
		if((date>=1 && date<=31) && (month>=1 && month<=12) && (year>=1947 && year<=2017))
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	public void submit()
	{
		try {
		String name1=name.getText();
	    String mm1=mm.getText();
	    String dd1=dd.getText();
	    String yy1=yy.getText();
	    String id1=id.getText();
	    if(DB.isInteger(dd1) && DB.isInteger(mm1) && DB.isInteger(yy1) && !mm1.isEmpty() && !dd1.isEmpty() && !yy1.isEmpty() && !name1.isEmpty())
	    {
	    	if(checkDate(dd1,mm1,yy1)) {
	    	String date=dd1+"/"+mm1+"/"+yy1;
	    	if(DB.addBooks(id1, name1, date))
	    	{
	    		alerT.createAlertI("DONE!","Book SuccessFully Added!");
	    		name.setText(null);
	    		dd.setText(null);
	    		yy.setText(null);
	    		id.setText(null);
	    	    mm.setText(null);
	    	}
	    	else {
	    		alerT.createAlertE("UnSuccessful","Book Cannot Be added,Try Again!");
	    	     }
	    }
	    else 
	    {
	    	alerT.createAlertE("Error!","Book Cannot Be Added,Please Try Again/Check Date!");
	    }
	    }}
		catch(Exception e)
		{
			alerT.createAlertE("Error!","Book Cannot Be Added,Please Try Again!");
		}
	}
	}


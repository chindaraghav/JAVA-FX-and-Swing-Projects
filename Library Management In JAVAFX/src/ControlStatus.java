import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControlStatus 
{
	public TextField txt1;
	public Label lbl;
	public void check()
	{
		try {
		String id=txt1.getText();
		if(DB.ifIdExist2(id,"booksdata")) 
		{
			lbl.setText("Current Status: "+DB.checkStatus(id));
		}
		else 
		{
			alerT.createAlertE("Operation Failed!","Cannot Check Status! Check BookId.");
		}
		}
		catch(Exception e) 
		{
			alerT.createAlertE("Operation Failed!", "Cannot Check Status!");
		}
	}
}

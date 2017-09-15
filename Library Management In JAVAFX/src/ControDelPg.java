import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControDelPg 
{
	public ImageView img;
	public TextField txt1,txt2;
	public void initialize()
	{
		Image i1=new Image("file:img6.jpg");
		img.setImage(i1);
	}
	public void deleteIt()
	{
		try {
			int id=Integer.valueOf(txt2.getText());
			String name=txt1.getText();
			if(DB.ifIdExist(id,"librariandata") && DB.isInteger(txt2.getText()) && DB.nameExist("librariandata", id, name))
			{
			Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setTitle("Confirmation Dialog");
	        alert.setHeaderText(null);
	        alert.setContentText("Are You Sure You Want To Delete This!");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK)
	{
		if(DB.DeleteRec(id,"librariandata")) {
			alerT.createAlertI("Record Deleted","Selected Record Has Been Successfully Deleted!");
		     MainDelLib.closeIt();	
		}
		else{
			alerT.createAlertE("Error!","Problem While Deleting Record Page,Try Again!");
		    }
	}
	else{
		MainDelLib.closeIt();
	    }
			}
			else {
				alerT.createAlertE("Error!","Cannot Delete The Record!");
			     }
		    }
		
	catch(Exception e)
	{
		alerT.createAlertE("Error!","Problem While Deleting Record!");
	}
	}
	}
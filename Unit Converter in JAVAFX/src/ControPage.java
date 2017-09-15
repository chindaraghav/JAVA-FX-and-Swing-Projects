import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class ControPage
{
	public RadioButton temp,weight,dist,curr;
	
	public void handle(ActionEvent event) throws IOException
	{
		if(temp.isSelected())
		{
			new Main_2_3();
			Main_2.closseIt();
		}
		if(weight.isSelected())
		{
			new MainW();
			 Main_2.closseIt();
		}
		if(dist.isSelected())
		{
			new MainDist();
            Main_2.closseIt();
		}
		if(curr.isSelected())
		{
			new MainCur();
			Main_2.closseIt();
		}
	}
	}


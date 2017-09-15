
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TempContro 
{
	public ComboBox<String> comb1,comb2;
	public Label lbll;
	public TextField txtt1;
	public Button calc;
	Image i1=new Image("file:download.png");
	
	public ImageView Img11;
	public void initialize()
	{
		Img11.setImage(i1);
	     comb1.getItems().addAll(
	    		 "Farenheit","Celcius"
	    		 );
	     comb2.getItems().addAll(
	    		 "Celcius","Farenheit"
	    		 );
	     comb1.setValue("Farenheit");
	     comb2.setValue("Celcius");
	}
	public void ext()
	{
		Main_2_3.close_It();
	}
	public void goBack() throws Exception
	{
		new Main_2();
		Main_2_3.close_It();
	}
		public void handComb(ActionEvent event)
		{
			try{if(txtt1.getText().equals(""))
			{
				lbll.setText("Type a Value!");}
			}
			catch(NumberFormatException e)
			{
				Alert a1=new Alert(AlertType.ERROR);

				a1.setHeaderText(null);
				a1.setTitle("Type Value!");
				a1.setContentText("Please Type Some value To Be Converted");
				a1.showAndWait();
			}
			if(comb2.getValue()==comb1.getValue())
			{
				lbll.setText("Result= "+txtt1.getText());
			}
			if(comb1.getValue().equals("Farenheit") && comb2.getValue().equals("Celcius")) {
				double a=Double.valueOf(txtt1.getText());
				lbll.setText("Result= "+calcCel(a)+superscript("0")+"C");
			}
             if(comb2.getValue().equals("Farenheit") && comb1.getValue().equals("Celcius")) {
            	 double a=Double.valueOf(txtt1.getText());
            	 lbll.setText("Result= "+calcFar(a)+superscript("0")+"F");
			}
	}
		public static String calcFar(double a)
		{

			a=((a*9)/5)+32;
			a=Math.round(a*100D)/100D;
			return ""+a;
		}
		public static String calcCel(double a)
		{
			

			a=((a-32)*5)/9;
			a=Math.round(a*100D)/100D;
			return ""+a;
		}
		public static String superscript(String str) {
		    str = str.replaceAll("0", "⁰");
		    str = str.replaceAll("1", "¹");
		    str = str.replaceAll("2", "²");
		    str = str.replaceAll("3", "³");
		    str = str.replaceAll("4", "⁴");
		    str = str.replaceAll("5", "⁵");
		    str = str.replaceAll("6", "⁶");
		    str = str.replaceAll("7", "⁷");
		    str = str.replaceAll("8", "⁸");
		    str = str.replaceAll("9", "⁹");         
		    return str;
		}
}




/*if((txtt1.getText()).equals(null))
{
	Alert a1=new Alert(AlertType.ERROR);
	a1.setHeaderText(null);
	a1.setTitle("Type Value!");
	a1.setContentText("Please Type Some value To Be Converted");
	a1.showAndWait();
}*/
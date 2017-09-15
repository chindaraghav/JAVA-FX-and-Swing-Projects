import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControCurr 
{
	public ComboBox<String> com1;
	public ComboBox<String> com2;
	public TextField txt;
	public Label lbl;
	public ImageView img;
	public Button exit1;
	public void initialize() {
		com1.getItems().addAll(
				"INR","USD","EUR","Pound"
				);
		com2.getItems().addAll(
				"INR","USD","EUR","Pound"
				);
		com1.setValue("USD");
		com2.setValue("USD");
		Image i1=new Image("file:currr.jpg");
		img.setImage(i1);
	}
	public void goBack() throws Exception
	{
		new Main_2();
		 MainCur.closeIt();
	}
public void handle()
{
	if(com1.getValue()==com2.getValue())
	{
		String a=com1.getValue();
	    String b=com2.getValue();
	    double v=Double.valueOf(txt.getText());
		if(com1.getValue()=="USD")
		{   lbl.setText("Result= "+v+"$");  }
		if(com1.getValue()=="INR")
		{   lbl.setText("Result= "+v+"₹");  }
		if(com1.getValue()=="EUR")
		{   lbl.setText("Result= "+v+"€");  }
		if(com1.getValue()=="Pound")
		{    lbl.setText("Result= "+v+"£"); }
	}
	else {
		String a=com1.getValue();
	    String b=com2.getValue();
	    double v=Double.valueOf(txt.getText());
		calcItt(a,b,v);
		}
	}
   public void exit()
   {
	   MainCur.closeIt();
    }
public void calcItt(String a,String b,double v)
{
	double result=0;
if(a.equals("USD")) {
if(b.equals("INR"))                             //all about Kilometers
{  result=v*64.46; lbl.setText("Result="+result+" ₹"); }
if(b.equals("Pound")) 
{	result=v*0.77; lbl.setText("Result="+result+" £"); }
if(b.equals("EUR")) 
{   result=v*0.86; lbl.setText("Result="+result+" €");	}
}

if(a.equals("INR")) {                          //all about Meters

	if( b.equals("USD")) 
	{   result=v*0.016; lbl.setText("Result="+result+" $"); 	 }
	if(b.equals("Pound")) 
	{   result=v*0.012; lbl.setText("Result="+result+" £"); 	 }
	if(b.equals("EUR")) 
	{   result=v*0.013;  lbl.setText("Result="+result+" €");	 }}

if(a.equals("Pound")) {                        //all about CentiMeter

	if( b.equals("USD")) 
	{   result=v*1.30; lbl.setText("Result="+result+" $"); 	 }
	if( b.equals("INR")) 
	{    result=v*83.77; lbl.setText("Result="+result+" ₹");	 }
	if(b.equals("EUR")) 
	{    result=v*1.11;  lbl.setText("Result="+result+" €"); 	 }}

if(a.equals("EUR")) {                         //all about Millimeter

	if(b.equals("USD")) 
	{   result=v*1.17;  lbl.setText("Result="+result+" $");	 }
	if(b.equals("INR")) 
	{  result=v*75.17;  lbl.setText("Result="+result+" ₹"); 	 }
	if(b.equals("Pound")) 
	{  result=v*0.90;   lbl.setText("Result="+result+" £");	 }
}
}
}

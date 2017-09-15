import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControDist 
{
	public Button calc,ext;
	public TextField txt;
	public Label lbl;
	public ComboBox<String> com1;
	public ComboBox<String> com2;
	public ImageView img;
	public void initialize()
	{
		com1.getItems().addAll(
			"KiloMeter (km)","Meter (m)","CentiMeter (cm)","MilliMeter (mm)"	
				);
             com2.getItems().addAll(
            			"KiloMeter (km)","Meter (m)","CentiMeter (cm)","MilliMeter (mm)"					
				);
             Image i1=new Image("file:img12.png");
             img.setImage(i1);
             com1.setValue("KiloMeter (km)");
             com2.setValue("Meter (m)");
	}
	public void EXIT()
	{
		MainDist.close_It();	
	}
	public void goBack() throws Exception
	{
		new Main_2();
		MainDist.close_It();
	}
	public void handle(ActionEvent event)
	{
		if(com1.getValue()==com2.getValue()) {
         	String a=com1.getValue();
			double v=Double.valueOf(txt.getText());
		if(a.equals("KiloMeter (km)")) {   lbl.setText("Result="+v+"km"); }
		if(a.equals("Meter (m)")) {   lbl.setText("Result="+v+"m"); }
		if(a.equals("CentiMeter (cm)")) {   lbl.setText("Result="+v+"cm"); }
		if(a.equals("MilliMeter (mm)")) {   lbl.setText("Result="+v+"mm"); }
		}
		else {
			String a=com1.getValue();
			String b=com2.getValue();
			double v=Double.valueOf(txt.getText());
			calcIt(a,b,v);
		}
	}
	public void calcIt(String a,String b,double v)
	{
		double result=0;
if(a.equals("KiloMeter (km)")) {
	if(b.equals("Meter (m)"))                             //all about Kilometers
	{  result=v*1000; lbl.setText("Result="+result+" m"); }
	if(b.equals("CentiMeter (cm)")) 
	{	result=v*100000; lbl.setText("Result="+result+" cm"); }
	if(b.equals("MilliMeter (mm)")) 
	{   result=v*1000000; lbl.setText("Result="+result+" mm");	}
 }
	
if(a.equals("Meter (m)")) {                          //all about Meters
	
		if( b.equals("CentiMeter (cm)")) 
		{   result=v*100; lbl.setText("Result="+result+" cm"); 	 }
		if(b.equals("MilliMeter (mm)")) 
		{   result=v*1000; lbl.setText("Result="+result+" mm"); 	 }
		if(b.equals("KiloMeter (km)")) 
		{   result=v/1000;  lbl.setText("Result="+result+" km");	 }}

if(a.equals("CentiMeter (cm)")) {                        //all about CentiMeter

		if( b.equals("MilliMeter (mm)")) 
		{   result=v*10; lbl.setText("Result="+result+" mm"); 	 }
		if( b.equals("KiloMeter (km)")) 
		{    result=v/100000; lbl.setText("Result="+result+" km");	 }
		if(b.equals("Meter (m)")) 
		{    result=v/100;  lbl.setText("Result="+result+" m"); 	 }}
	
if(a.equals("MilliMeter (mm)")) {                         //all about Millimeter
	
		if(b.equals("CentiMeter (cm)")) 
		{   result=v/10;  lbl.setText("Result="+result+" cm");	 }
		if(b.equals("KiloMeter (km)")) 
		{  result=v/1000000;  lbl.setText("Result="+result+" km"); 	 }
		if(b.equals("Meter (m)")) 
		{  result=v/1000;   lbl.setText("Result="+result+" m");	 }}
}
}
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControWeight {
	public Button ext;
	public TextField txt;
	public Label lbl;
	public ComboBox<String> com1;
	public ComboBox<String> com2;
	public ImageView img;
	public void initialize()
	{
		com1.getItems().addAll(
			"KiloGram (kg)","Gram (gm)","ounce (oz)","Pound (lb)"	
				);
             com2.getItems().addAll(
            		 "KiloGram (kg)","Gram (gm)","ounce (oz)","Pound (lb)"						
				);
             Image i1=new Image("file:ww.jpg");
             img.setImage(i1);
             com1.setValue("KiloGram (kg)");
             com2.setValue("KiloGram (kg)");
	}
	public void EXIT()
	{
		MainW.closeIt();	
	}
	public void goBack() throws Exception
	{
		new Main_2();
		MainW.closeIt();
	}
	public void handle(ActionEvent event)
	{
		if(com1.getValue()==com2.getValue()) {
         	String a=com1.getValue();
			double v=Double.valueOf(txt.getText());
		if(a.equals("KiloGram (kg)")) {   lbl.setText("Result="+v+"kg"); }
		if(a.equals("Gram (gm)")) {   lbl.setText("Result="+v+"gm"); }
		if(a.equals("ounce (oz)")) {   lbl.setText("Result="+v+"oz"); }
		if(a.equals("Pound (lb)")) {   lbl.setText("Result="+v+"lb"); }
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
if(a.equals("KiloGram (kg)")) {
	if(b.equals("Gram (gm)"))                             //all about Kilograms
	{  result=v*1000; lbl.setText("Result="+result+" gm"); }
	if(b.equals("Ounce (oz)")) 
	{	result=v*35.27; lbl.setText("Result="+result+" oz"); }
	if(b.equals("Pound (lb)")) 
	{   result=v*2.20; lbl.setText("Result="+result+" lb");	}
 }
	
if(a.equals("Gram (gm)")) {                          //all about Gram
	
		if( b.equals("Ounce (oz)")) 
		{   result=v*0.035; lbl.setText("Result="+result+" oz"); 	 }
		if(b.equals("Pound (lb)")) 
		{   result=v*0.0022; lbl.setText("Result="+result+" lb"); 	 }
		if(b.equals("KiloGram (kg)")) 
		{   result=v*0.001;  lbl.setText("Result="+result+" kg");	 }}

if(a.equals("Ounce (oz)")) {                        //all about Ounce

		if( b.equals("Pound (lb)")) 
		{   result=v*0.062; lbl.setText("Result="+result+" lb"); 	 }
		if( b.equals("KiloGram (kg)")) 
		{    result=v*0.028; lbl.setText("Result="+result+" kg");	 }
		if(b.equals("Gram (gm)")) 
		{    result=v*28.34;  lbl.setText("Result="+result+" gm"); 	 }}
	
if(a.equals("Pound (lb)")) {                         //all about Pound
	
		if(b.equals("Ounce (oz)")) 
		{   result=v*16;  lbl.setText("Result="+result+" oz");	 }
		if(b.equals("KiloGram (kg)")) 
		{  result=v*0.45;  lbl.setText("Result="+result+" kg"); 	 }
		if(b.equals("Gram (gm)")) 
		{  result=v*453.59;   lbl.setText("Result="+result+" gm");	 }}
}
}

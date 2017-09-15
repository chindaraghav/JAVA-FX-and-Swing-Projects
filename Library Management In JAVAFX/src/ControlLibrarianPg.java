import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControlLibrarianPg 
{
	public Label lbl;
	public void add()
	{
		new AddBookPg();
	}
	public void select() 
	{

	}
	public void status() 
	{
		new CheckStatusMain();
	}
	public void issue() 
	{
		new IssuePgMain();
	}
	public void receive() 
	{
		new ReceiveMain();
	}
	public void newM() 
	{
		new MemFormMain();
	}
	public void about() 
	{
		new MainMemberT();
	}
	public void logOut()
	{
	MainPg g=new MainPg();
	g.start(new Stage());
	LibrarianPg.CloseIt();
	}
}

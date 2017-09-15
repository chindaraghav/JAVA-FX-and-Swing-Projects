package model;
import java.sql.*;

public class DBmain 
{
	public static Connection connect() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection cn=null;
		cn=DriverManager.getConnection("jdbc:sqlite:CarRentalDB.sqlite");
		return cn;
		
	}
	public static boolean checkLogin(String a,String b) throws Exception
	{
		String username="";
		String password="";
		Connection cn=connect();
		String query="select * from login";
		Statement sc=cn.createStatement();
		ResultSet rs=sc.executeQuery(query);
		username=rs.getString("username");
		password=rs.getString("password");
		if(a.equals(username) && b.equals(password))
		{
			cn.close();
			return true;
		}
		else
		{
			cn.close();
			return false;
		}
	}
	public static boolean changeUserAndPass(String prevUsername,String prevPass,String newUser,String newPass) throws Exception
	{
		Connection cn=connect();
		if(checkLogin(prevUsername,prevPass))
		{
			String query2="delete from login where rowid=1";
			String query3="insert into login values (?,?)";
			Statement st=cn.createStatement();
			st.executeUpdate(query2);
			PreparedStatement st1=cn.prepareStatement(query3);
			st1.setString(1,newUser);
			st1.setString(2,newPass);
		   st1.executeUpdate();
		   cn.close();
	       return true;
		}
		else
		{
			cn.close();
			return false;
		}
		
	}
	public static boolean isInteger(String s) {
	     s=s.trim();
	     boolean status=true;
		for(int i=0;i<s.length();i++)
		{
	    char a=s.charAt(i);
	    if(a=='0'||a=='1'||a=='2' ||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9')
	    {
	    	 status =true;
	    }
	    else {
	    	status=false;
	    	break;
	    }
		}
		return status;
	}
} 

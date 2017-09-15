
import java.sql.*;
public class DB 
{
	public static Connection connect() throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection cn=null;
		 cn=DriverManager.getConnection("jdbc:sqlite:LibraryManagement.sqlite");
		 return cn;
		 
	}
	public static boolean ifIdExist(int id,String table) throws Exception
	{
		Connection cn= connect();
		String query="select * from "+table+" where id="+id+"" ;
		Statement sc=cn.createStatement();
		  ResultSet rs=null;
		  rs=sc.executeQuery(query);
		  if(rs.next())
		  {
			  cn.close();
			  return true;
		  }
		  else {
			  cn.close();
			  return false;
		  }}
	
	public static boolean addToLibrarianData(int id,String name,String address,String city,String phone,String email,String pass) throws Exception
	{
			if(ifIdExist(id,"librariandata")==false) {
			String query="insert into librariandata values(?,?,?,?,?,?,?)";
		    Connection cn=connect();
		   PreparedStatement st=cn.prepareStatement(query);
		   st.setInt(1,id);
		   st.setString(2, name);
		   st.setString(3, address);
		   st.setString(4, city);
		   st.setString(5, phone);
		   st.setString(6, email);
		   st.setString(7, pass);
		   st.executeUpdate();
		   cn.close();
		   return true;
		}
			else {
				return false;
			}
			}
	
	public static boolean DeleteRec(int id,String table)throws Exception
	{
		Connection sc=connect();
		if(ifIdExist(id,table))
		{
			String query="delete from "+table+" where id="+id+"";
			Statement st=sc.createStatement();
			st.executeUpdate(query);
			sc.close();
			return true;
			
		}
		else {
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
	public static boolean nameExist(String table,int id,String name) throws Exception
	{
		Connection cn=connect();
		String query="select name from "+table+" where id="+id+"";
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String value=rs.getString("name");
		if(value.equals(name))
		{
			cn.close();
			return true;
		}
		else {
			cn.close();
			return false;
		}
	}
	public static boolean passExist(String table,int id,String pass) throws Exception
	{
		Connection cn=connect();
		String query="select password from "+table+" where id="+id+"";
		Statement st=cn.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String value=rs.getString("password");
		if(value.equals(pass))
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
	public static boolean ifIdExist2(String id,String table) throws Exception
	{
		Connection cn= connect();
		String query="select * from "+table+" where bookId="+id+"" ;
		Statement sc=cn.createStatement();
		  ResultSet rs=null;
		  rs=sc.executeQuery(query);
		  if(rs.next())
		  {
			  return true;
		  }
		  else {
			  return false;
		  }}
	public static boolean addBooks(String id,String name,String date) throws Exception
    {
    	if(ifIdExist2(id,"booksdata")==false)
    	{
    	 Connection cn=connect();
    	 String query="insert into booksdata values(?,?,?,?)";
    	 PreparedStatement st=cn.prepareStatement(query);
    	 st.setString(1, id);
    	 st.setString(2,name);
    	 st.setString(3,date);
    	 st.setString(4,"in-Lib");
    	 st.executeUpdate();
    	 cn.close();
    	 return true;
    	}
    	else {
    		
    		alerT.createAlertE("Error!","Cannot Add Book Please Try Again!");
    		return false;
    	
    	}
    }
	
	public static String checkStatus(String id) throws Exception
	{
		Connection cn=DB.connect();
		if(DB.ifIdExist2(id,"booksdata")) 
		{
			String query="select status from booksdata where bookId="+id+"";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String a=rs.getString("status");
			cn.close();
			return a;
		}
		else {
			cn.close();
			return null;
		}
		
	}
	public static boolean ifIdExist3(String id,String table) throws Exception
	{
		Connection cn= connect();
		String query="select * from "+table+" where id="+id+"" ;
		Statement sc=cn.createStatement();
		  ResultSet rs=null;
		  rs=sc.executeQuery(query);
		  if(rs.next())
		  {
			  return true;
		  }
		  else {
			  return false;
		  }}    
	public static boolean addNewMember(String id,String  name,String fathername,String phone,String email,String address) throws Exception
	{
		if(ifIdExist3(id,"memberdata")==false && isInteger(phone))
		{
		Connection cn=connect();
		String query="insert into memberdata values(?,?,?,?,?,?)";
		PreparedStatement st=cn.prepareStatement(query);
		st.setString(1,id);
		st.setString(2,name);
		st.setString(3,fathername);
		st.setString(4,phone);
		st.setString(5,email);
		st.setString(6,address);
		st.executeUpdate();
		cn.close();
		return true;
		}
		else
		{
			return false;
		}
	}
    public static boolean bookExist(String id)throws Exception
    {
    	Connection cn= connect();
		String query="select * from booksdata where bookId="+id+"" ;
		Statement sc=cn.createStatement();
		  ResultSet rs=null;
		  rs=sc.executeQuery(query);
		  if(rs.next())
		  {
			  cn.close();
			  return true;
		  }
		  else {
			  cn.close();
			  return false;
		  }
    }
	public static boolean issueBook(String memid,String name,String bookid)throws Exception
     {
    	 if(bookExist(bookid) && ifIdExist3(memid,"memberdata"))
    	 {
    	 Connection cn=connect();
    	 String query="insert into issuedbooks values(?,?,?)";
    	 PreparedStatement sc=cn.prepareStatement(query);
    	 sc.setString(1,memid);
    	 sc.setString(2,name);
    	 sc.setString(3,bookid);
    	 sc.executeUpdate();
    	 String queryy="update booksdata set status='"+"with "+memid+"' where bookid="+bookid+"";
    	 Statement st=cn.createStatement();
    	 st.executeUpdate(queryy);
    	 cn.close();
    	 return true;
    	 }
    	 else
    	 {
    		 return false;
    	 }
     }
    public static boolean updateStatus(String bookid,String memid)throws Exception
    {
    	if(bookExist(bookid) && ifIdExist3(memid,"memberdata"))
    	{
    	Connection cn=DB.connect();
   	    String queryy="update booksdata set status='In-Lib' where bookid="+bookid+"";
        Statement st=cn.createStatement();
    	st.executeUpdate(queryy);
    	cn.close();
    	return true;
    }
    	else {
    		return false;
    	}
    	}

    public static void main(String[] args)throws Exception 
    {
	}

}
	


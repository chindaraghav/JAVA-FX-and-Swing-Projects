package model;

import java.sql.*;

public class Contracts 
{
	public static boolean IdExist(String id,String table) throws Exception
	{
		Connection cn=DBmain.connect();
		String query="select * from "+table+" where customerid="+id+"";
		Statement st=cn.createStatement();
		ResultSet rs=null;
		rs=st.executeQuery(query);
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
	public static boolean addContract(String id,String name,String fname,String phone,String address,String destination,String kms,
			String from,String to,String car,String fare,String advance,String document,String date) throws Exception
	{
		Connection cn=DBmain.connect();
		if(!IdExist(id,"Rent") && DBmain.isInteger(phone) && DBmain.isInteger(kms) && DBmain.isInteger(fare) && DBmain.isInteger(advance))
		{
			String query="insert into Rent values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1,id);
			st.setString(2,name);
			st.setString(3,fname);
			st.setString(4,phone);
			st.setString(5,address);
			st.setString(6,destination);
			st.setString(7,kms);
			st.setString(8,from);
			st.setString(9,to);
			st.setString(10,car);
			st.setString(11,fare);
			st.setString(12,advance);
			st.setString(13,document);
			st.setString(14,date);
			st.executeUpdate();
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean checkContract(String cid,String name,String Phone) throws Exception
	{
		Connection cn=DBmain.connect();
		String query="select * from Rent where customerid="+cid+"";
		Statement st=cn.createStatement();
		ResultSet rs=null;
		rs=st.executeQuery(query);
		if(rs.next())
		  {
			if(rs.getString("name").equals(name)&& rs.getString("phone").equals(Phone))
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
		  else 
		  {
			  cn.close();
			  return false;
		  }
		}
	public static boolean deleteContr(String cid) throws Exception
	{
		if(IdExist(cid,"Rent"))
		{
			Connection cn=DBmain.connect();
			String query="delete from Rent where customerid="+cid+"";
			Statement st=cn.createStatement();
			st.executeUpdate(query);
			cn.close();
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isCarBooked(String cid) throws Exception
	{
		if(!IdExist(cid,"cars"))
		{
			if(!IdExist2(cid,"Rent"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public static boolean IdExist2(String id,String table) throws Exception
	{
		Connection cn=DBmain.connect();
		String query="select * from "+table+" where car="+id+"";
		Statement st=cn.createStatement();
		ResultSet rs=null;
		rs=st.executeQuery(query);
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
}

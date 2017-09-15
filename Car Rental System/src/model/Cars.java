package model;

import java.sql.*;

public class Cars 
{
	public static boolean IdExist(String id,String table) throws Exception
	{
		Connection cn=DBmain.connect();
		String query="select * from "+table+" where carID="+id+"";
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
	public static boolean addCar(String carId,String model,String plateNo,String year,String Date,String dent,String condition,String chassis) throws Exception
	{
	
		if(!IdExist(carId,"cars") && DBmain.isInteger(dent))
		{
			Connection cn=DBmain.connect();
			String query="insert into cars values(?,?,?,?,?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1,model);
			st.setString(2,chassis);
			st.setString(3,plateNo);
			st.setString(4,year);
			st.setString(5,Date);
			st.setString(6,dent);
			st.setString(7,condition);
			st.setString(8,carId);
			st.executeUpdate();
			cn.close();
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean delCar(String carID) throws Exception
	{
		if(IdExist(carID,"cars"))
		{
			Connection sc=DBmain.connect();
			String query="delete from cars where carID="+carID+"";
			Statement st=sc.createStatement();
			st.executeUpdate(query);
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args) throws Exception {
		delCar("1222");
	}
}

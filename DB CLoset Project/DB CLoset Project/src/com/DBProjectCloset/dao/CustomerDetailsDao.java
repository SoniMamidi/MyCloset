package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DBProjectCloset.model.*;
public class CustomerDetailsDao {
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	  public static String USER_TYPE="";
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:2033/spartandb","root","krishnateja");
	            //System.out.println(con.isReadOnly());
	        }
	            catch(Exception e){System.out.println(e);}  
		        return con;
	   }
	   public User getCustomer(int customerid)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from Person where id=?");
			   ps.setInt(1,customerid);
			   resultSet=ps.executeQuery();
			   User user=new User();
			   while(resultSet.next())
			   {
				   user.setName(resultSet.getString("name"));
				   user.setUsername(resultSet.getString("username"));
				   user.setEmail(resultSet.getString("email"));
			   }
			   return user;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
}

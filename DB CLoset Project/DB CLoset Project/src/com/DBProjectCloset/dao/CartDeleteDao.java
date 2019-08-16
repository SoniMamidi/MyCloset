package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DBProjectCloset.model.*;
public class CartDeleteDao {
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
	   public void delete_cart(int customer_id)
	   {
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement pst=(PreparedStatement) con.prepareStatement("delete from cart where customerid=?");
			   pst.setInt(1,customer_id);
			   pst.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   
		   }
		   
	   }
}

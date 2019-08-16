package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBProjectCloset.controller.SendMail;
import com.DBProjectCloset.model.*;
public class ItemApproveDao {
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
	   public int update_item(int item_id,int customer_id,String message,String email)
	   {
		   int status=0;
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement pst=(PreparedStatement)con.prepareStatement("update Items set isapproved=? where itemid=?");
			   pst.setBoolean(1, true);
			   pst.setInt(2, item_id);
			   status=pst.executeUpdate();
			   PreparedStatement statement1 = (PreparedStatement)con.prepareStatement("insert into taxdocument(item_id,customer_id,message) values(?,?,?)");
			   statement1.setInt(1,item_id);
			   statement1.setInt(2, customer_id);
			   statement1.setString(3,message);
			   statement1.executeUpdate();
			   SendMail s=new SendMail();
			   s.signUpMail(message,email);
			   return status;
		   }
		   
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return 0;
	   }
	   public int update_itemSold(int item_id)
	   {
		   int status=0;
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement pst=(PreparedStatement)con.prepareStatement("update Items set issold=? where itemid=?");
			   pst.setBoolean(1, true);
			   pst.setInt(2, item_id);
			   status=pst.executeUpdate();
			   return status;
		   }
		   
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return 0;
	   }
	   
}

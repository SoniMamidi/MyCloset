package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBProjectCloset.controller.SendMail;
import com.DBProjectCloset.model.*;
public class ItemsUpdateDao {
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
	   public int update_item(Items item)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement = (PreparedStatement)con.prepareStatement("update Items set isapproved=true where itemid=?");
			   statement.setInt(1, item.getItemid());
			   status=statement.executeUpdate();
			   PreparedStatement statement1 = (PreparedStatement)con.prepareStatement("insert into taxdocument(item_id,customer_id,message) values(?,?,?)");
			   statement1.setInt(1, item.getItemid());
			   statement1.setInt(2, item.getCustomer_id());
			   statement1.setString(3,"Hello Item is approved");
			   status=statement1.executeUpdate();
			   SendMail s=new SendMail();
			   s.signUpMail("Approved", "Mail From Closet");
			   con.close();
		   }
		   catch(Exception e)
		   {
			   
		   }
		   return 0;
	   }
	   public int update_itemSold(CartItem item)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement = (PreparedStatement)con.prepareStatement("update Items set issold=true where itemid=?");
			   statement.setInt(1, item.getItemid());
			   status=statement.executeUpdate();
			   SendMail s=new SendMail();
			   s.signUpMail("Approved", "Mail From Closet");
			   con.close();
		   }
		   catch(Exception e)
		   {
			   
		   }
		   return 0;
	   }
	   
}

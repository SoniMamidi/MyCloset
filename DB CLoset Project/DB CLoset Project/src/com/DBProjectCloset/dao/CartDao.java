package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBProjectCloset.model.*;
public class CartDao {
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
	   
	   public int delete_cart(int cartID)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("delete from cart where cartid=?");
			   statement.setInt(1,cartID);
			   status=statement.executeUpdate();
			   return status;
		   }
		   catch(Exception e)
		   {
			  e.printStackTrace(); 
		   }
		   return 0;
	   }
	   public int insert_cart(CartItem cartItem)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("insert into cart(itemid,itemname,imageurl,customerid,itemprice) values(?,?,?,?,?)");
			   statement.setInt(1,cartItem.getItemid());
			   statement.setString(3,cartItem.getImgURl());
			   statement.setString(2,cartItem.getItemName());
			   statement.setInt(4,cartItem.getCustomerID());
			   statement.setDouble(5,cartItem.getItemPrice());
			   status=statement.executeUpdate();
			   return status;
			   
		   }
		   catch(Exception e)
		   {
			  e.printStackTrace(); 
		   }
		   return status;
	   }
	   public ArrayList<CartItem> getCartItems(int customerID)
	   { 
		   try{
			   Connection con=getConnection();
			   ArrayList<CartItem> items=new ArrayList<CartItem>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from cart where customerid=?");
	           statement.setInt(1,customerID);
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   CartItem item=new CartItem();
	        	   item.setCustomerID(customerID);
	        	   item.setImgURl(resultSet.getString("imageurl"));
	        	   item.setItemName(resultSet.getString("itemname"));
	        	   item.setItemid(resultSet.getInt("itemid"));
	        	   item.setItemPrice(resultSet.getDouble("itemprice"));
	        	   item.setCartItemID(resultSet.getInt("cartid"));
	    		   items.add(item);
	           }
	           return items;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
	   
}

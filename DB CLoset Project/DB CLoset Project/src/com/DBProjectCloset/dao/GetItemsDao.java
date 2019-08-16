package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.DBProjectCloset.model.*;
public class GetItemsDao {
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
	   public ArrayList<Items> getItems(boolean flag)
	   { 
		   try{
			   Connection con=getConnection();
			   ArrayList<Items> items=new ArrayList<Items>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from Items where isapproved=? and issold=?");
	           statement.setBoolean(1,flag);
	           statement.setBoolean(2, !flag);
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   Items item=new Items();
	        	   item.setItemid(resultSet.getInt("itemid"));
	        	   item.setItemprice(resultSet.getDouble("itemprice"));
	    		   item.setCategory(resultSet.getString("category"));
	    		   item.setName(resultSet.getString("name"));
	    		   item.setDescription(resultSet.getString("description"));
	    		   item.setImagebrand(resultSet.getString("itembrand"));
	    		   item.setSize(resultSet.getString("size"));
	    		   item.setColor(resultSet.getString("color"));
	    		   item.setItemAge(resultSet.getString("itemAge"));
	    		   item.setImageurl(resultSet.getString("imageurl"));
	    		   item.setGender(resultSet.getString("gender"));
	    		   item.setQuantity(resultSet.getString("quantity"));
	    		   item.setCustomer_id(resultSet.getInt("customer_id"));
	    		   item.setRequested_price(resultSet.getDouble("requested_price"));
	    		   item.setDonorstatus(resultSet.getString("donorstatus"));
	    		   item.setIsapproved(resultSet.getBoolean("isapproved"));
	    		   item.setApproved_by(resultSet.getString("approved_by"));
	    		   item.setDate_posted(resultSet.getString("date_posted"));
	    		   item.setDiscount(resultSet.getDouble("discount"));
	    		   item.setIssold(resultSet.getBoolean("issold"));
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
	   public ArrayList<Items> getUnApprovedItems(boolean flag)
	   { 
		   try{
			   Connection con=getConnection();
			   ArrayList<Items> items=new ArrayList<Items>();
			   PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from Items where isapproved=?");
	           statement.setBoolean(1,flag);
	           resultSet=statement.executeQuery();
	           while(resultSet.next())
	           {
	        	   Items item=new Items();
	        	   item.setItemid(resultSet.getInt("itemid"));
	        	   item.setItemprice(resultSet.getDouble("itemprice"));
	    		   item.setCategory(resultSet.getString("category"));
	    		   item.setName(resultSet.getString("name"));
	    		   item.setDescription(resultSet.getString("description"));
	    		   item.setImagebrand(resultSet.getString("itembrand"));
	    		   item.setSize(resultSet.getString("size"));
	    		   item.setColor(resultSet.getString("color"));
	    		   item.setItemAge(resultSet.getString("itemAge"));
	    		   item.setImageurl(resultSet.getString("imageurl"));
	    		   item.setGender(resultSet.getString("gender"));
	    		   item.setQuantity(resultSet.getString("quantity"));
	    		   item.setCustomer_id(resultSet.getInt("customer_id"));
	    		   item.setRequested_price(resultSet.getDouble("requested_price"));
	    		   item.setDonorstatus(resultSet.getString("donorstatus"));
	    		   item.setIsapproved(resultSet.getBoolean("isapproved"));
	    		   item.setApproved_by(resultSet.getString("approved_by"));
	    		   item.setDate_posted(resultSet.getString("date_posted"));
	    		   item.setDiscount(resultSet.getDouble("discount"));
	    		   item.setIssold(resultSet.getBoolean("issold"));
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

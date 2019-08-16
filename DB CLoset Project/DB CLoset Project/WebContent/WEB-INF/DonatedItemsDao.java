package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.DBProjectCloset.model.*;
public class DonatedItemsDao {
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
	  public static String USER_TYPE="";
	  private static Statement statement=null;
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
	   
	   public void getDonatedItems(){
		   try{
		   		Connection con=getConnection();
		   		statement=con.createStatement();
		   		resultSet = statement.executeQuery("select * from donateditems");
		   		DonatedItems toAddItems= new DonatedItems();
		   		ArrayList<DonatedItems> itemsList=new ArrayList<DonatedItems>();
		   		
	            while(resultSet.next())
	    		{
	    			toAddItems.setItem_ID(resultSet.getInt("item_id"));
	    			toAddItems.setCategory(resultSet.getString("category"));
	    			toAddItems.setItem_Condition(resultSet.getString("item_condition"));
	    			toAddItems.setDescription(resultSet.getString("description"));
	    			toAddItems.setType(resultSet.getString("type"));
	    			toAddItems.setSize(resultSet.getString("size"));
	    			toAddItems.setColor(resultSet.getString("color"));
	    			toAddItems.setPicture_URL(resultSet.getString("picture"));
	    			toAddItems.setGender(resultSet.getString("gender"));
	    			toAddItems.setQuantity(resultSet.getInt("quantity"));
	    			toAddItems.setDonor_ID(resultSet.getInt("donor_id"));
	    			itemsList.add(toAddItems);
	    		}
		   }
		   catch(Exception e)
		   {System.out.println(e);}
	            
	   }
}

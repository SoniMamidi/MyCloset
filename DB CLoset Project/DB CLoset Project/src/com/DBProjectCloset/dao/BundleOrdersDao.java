package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBProjectCloset.model.*;
public class BundleOrdersDao {
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
	   public BundleOrders getBundles(String bundle_id)
	   {
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from bundleorders where bundle_id=?");
			   ps.setString(1,bundle_id);
			   resultSet=ps.executeQuery();
			   BundleOrders toAdd=null;
			   while(resultSet.next())
			   {
				   toAdd=new BundleOrders();
				   toAdd.setBundle_id(resultSet.getString("bundle_id"));
				   toAdd.setId(resultSet.getInt("id"));
				   toAdd.setShipping(resultSet.getInt("shipping"));
				   toAdd.setTax(resultSet.getInt("tax"));
				   toAdd.setTotal_order(resultSet.getInt("total_order"));
				   toAdd.setGrand_total(resultSet.getInt("grand_total"));
			   }
			   return toAdd;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
}

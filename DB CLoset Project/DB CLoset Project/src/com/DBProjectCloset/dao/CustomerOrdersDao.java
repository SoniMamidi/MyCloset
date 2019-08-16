package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBProjectCloset.model.*;
public class CustomerOrdersDao {
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
	   public ArrayList<Order> getOrders(int customer_id)
	   {
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from orders where customer_id=?");
			   pst.setInt(1,customer_id);
			   resultSet=pst.executeQuery();
			   ArrayList<Order> ordersList=new ArrayList<Order>();
			   while(resultSet.next())
			   {
				   Order order=new Order();
				   order=new Order();
				   order.setOrder_id(resultSet.getInt("order_id"));
				   order.setBundle_id(resultSet.getString("bundle_id"));
				   order.setCustomer_id(resultSet.getInt("customer_id"));
				   order.setDate_ordered(resultSet.getString("date_ordered"));
				   order.setOrder_status(resultSet.getString("order_status"));
				   order.setItem_id(resultSet.getInt("item_id")); 
				   ordersList.add(order);
			   }
			   return ordersList;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
}

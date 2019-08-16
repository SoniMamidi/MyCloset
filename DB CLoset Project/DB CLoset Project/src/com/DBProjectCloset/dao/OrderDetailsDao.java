package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBProjectCloset.model.*;
public class OrderDetailsDao {
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
	   public ArrayList<Order> getOrders(){
		   ArrayList<Order> ordersList=new ArrayList<Order>();
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from orders");
			   resultSet=ps.executeQuery();
			   Order order;
			   while(resultSet.next())
			   {
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
		   
	   
	   public Order getOrderDetails(int orderid)
	   {
		   try
		   {
			   Connection con=getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from orders where order_id=?");
			   ps.setInt(1,orderid);
			   resultSet=ps.executeQuery();
			   Order order=new Order();
			   while(resultSet.next())
			   {
				   order.setOrder_id(resultSet.getInt("order_id"));
				   order.setBundle_id(resultSet.getString("bundle_id"));
				   order.setCustomer_id(resultSet.getInt("customer_id"));
				   order.setDate_ordered(resultSet.getString("date_ordered"));
				   order.setOrder_status(resultSet.getString("order_status"));
				   order.setItem_id(resultSet.getInt("item_id"));   
			   }
			   return order;
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }
}

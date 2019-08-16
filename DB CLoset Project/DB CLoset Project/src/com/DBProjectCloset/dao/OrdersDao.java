package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.DBProjectCloset.model.*;
import com.mysql.jdbc.CallableStatement;
public class OrdersDao {
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
	   public static String generateRandomWords()
	   {
	       String randomStrings ="";
	       Random random = new Random();
	       
	           char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	           for(int j = 0; j < word.length; j++)
	           {
	               word[j] = (char)('a' + random.nextInt(26));
	           }
	           randomStrings = new String(word);
	       
	       return randomStrings;
	   }
	   //public ArrayList<>
	   public int place_order(ArrayList<CartItem> itemList,double total,double tax,int shipping,int customerID)
	   {
		   int status=0;
		   CartItem item;
		   String bundle_id=generateRandomWords();
		   Date date=new Date();
		   SimpleDateFormat dateFormat=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
		   try{
			   Connection con=getConnection();
			   for(int i=0;i<itemList.size();i++)
			   {
				   item=itemList.get(i);
				   PreparedStatement statement =(PreparedStatement)con.prepareStatement("insert into orders"
			   		+ "(bundle_id,item_id,customer_id,date_ordered,order_status) values(?,?,?,?,?)");
				   statement.setString(1,bundle_id);
				   statement.setInt(2,item.getItemid());
				   statement.setInt(3,customerID);
				   statement.setString(4,dateFormat.format(date));
				   statement.setString(5,"Created");
				   status=status+statement.executeUpdate();
			   }
			   PreparedStatement ps =(PreparedStatement)con.prepareStatement("insert into bundleOrders"
				   		+ "(bundle_id,total_order,shipping,tax) values(?,?,?,?)");
			   ps.setString(1,bundle_id);
			   ps.setDouble(2,total);
			   ps.setInt(3,shipping);
			   ps.setDouble(4,tax);
			   status=status+ps.executeUpdate();
			   CallableStatement cstmt = (CallableStatement) con.prepareCall("{call total_sum(?)}");
			   cstmt.setString(1,bundle_id);
			   boolean flag=cstmt.execute();
			   if(flag){
			   return status;
			   }
			   else{
				   return 0;
			   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return 0;
	   }
}

package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.DBProjectCloset.model.*;
public class ItemUploadDao {
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
	   public int set_item(Items item)
	   {
		   int status=0;
		   try{
			   Connection con=getConnection();
			   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert "
			   		+ "into items values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			   ps.setInt(1,item.getItemid());
			   ps.setDouble(2,item.getItemprice());
			   ps.setString(3,item.getCategory());
			   ps.setString(4,item.getName());
			   ps.setString(5,item.getDescription());
			   ps.setString(6,item.getImagebrand());
			   ps.setString(7,item.getSize());
			   ps.setString(8,item.getColor());
			   ps.setString(9,item.getItemAge());
			   ps.setString(10,item.getImageurl());
			   ps.setString(11,item.getGender());
			   ps.setString(12,item.getQuantity());
			   ps.setInt(13,item.getCustomer_id());
			   ps.setDouble(14,item.getRequested_price());
			   ps.setString(15,item.getDonorstatus());
			   ps.setBoolean(16,item.isIsapproved());
			   ps.setString(17,item.getApproved_by());
			   ps.setString(18,item.getDate_posted());
			   ps.setDouble(19,item.getDiscount());
			   ps.setBoolean(20,item.isIssold());
			   status=ps.executeUpdate();
	           con.close(); 
			   }
			   catch(Exception ex){
				   ex.printStackTrace();
			   }
			   return status;
		   }
	   }


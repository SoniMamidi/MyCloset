package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.DBProjectCloset.model.*;
public class DeleteItemDao {
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
	   public int delete_Item(int item_id)
	   {
		   int status=0;
		   try
		   {
			Connection con=getConnection();
			PreparedStatement pst=(PreparedStatement)con.prepareStatement("delete from Items where itemid=?");
			pst.setInt(1, item_id);
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

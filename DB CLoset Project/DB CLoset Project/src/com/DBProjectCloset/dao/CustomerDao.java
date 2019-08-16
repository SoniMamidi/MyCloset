package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
	private static ResultSet resultSet = null;
	  private static PreparedStatement pstatement=null;
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
	   public int customer_update(int id,String connection,boolean newsletter)
	   {
		   int status=0;
		   try{
		   //Address yet to be added in the database (person table)
		  //preparedstatement yet to be created down here 
		   Connection con=getConnection();
               PreparedStatement pstatement=(PreparedStatement) con.prepareStatement("insert into customer values(?,?,?)");
        	   pstatement.setInt(1,id);//retrieved from session
        	   pstatement.setString(2,connection);//connection
        	   pstatement.setBoolean(3,newsletter);
        	   
        	   status=pstatement.executeUpdate();
         
           //con.close(); 
		   }
		   catch(Exception ex){
			   ex.printStackTrace();
		   }
		   return status;
	   }
}

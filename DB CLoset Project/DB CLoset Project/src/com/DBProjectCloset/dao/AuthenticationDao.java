package com.DBProjectCloset.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBProjectCloset.controller.SendMail;
import com.DBProjectCloset.model.*;
public class AuthenticationDao {
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
	   public int signup_check(User user,Address address)
	   {
		   int status=0;
		   try{
		   //Address yet to be added in the database (person table)
		  //preparedstatement yet to be created down here 
		   Connection con=getConnection();
		   PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert "
		   		+ "into person(name,phone_no,username,password,type,email) values (?,?,?,?,?,?)");
		   ps.setString(1,user.getName());
		   ps.setString(2,user.getPhone_no());
		   ps.setString(3,user.getUsername());
		   ps.setString(4,user.getPassword());
		   ps.setString(5,user.getType());
		   ps.setString(6,user.getEmail());
           status=ps.executeUpdate();
           PreparedStatement statement=(PreparedStatement) con.prepareStatement("select id from person where username=?");
           statement.setString(1,user.getUsername());
           resultSet=statement.executeQuery();
           while(resultSet.next())
           {
        	   PreparedStatement pstatement=(PreparedStatement) con.prepareStatement("insert into address values(?,?,?,?,?,?)");
        	   pstatement.setInt(1,resultSet.getInt("id"));
        	   pstatement.setString(2,address.getAddressLine());
        	   pstatement.setString(3,address.getCity());
        	   pstatement.setString(4,address.getState());
        	   pstatement.setInt(5,Integer.parseInt(address.getZipCode()));
        	   pstatement.setString(6,"");
        	   status=pstatement.executeUpdate();
           }
           //con.close(); 
		   }
		   catch(Exception ex){
			   ex.printStackTrace();
		   }
		   return status;
	   }
	   public User login_Check(String userName,String password){
		   User user=new User();
		   try{
		   		Connection con=getConnection();
	             pstatement=(PreparedStatement) con.prepareStatement("select * "
	            		+ "from person where username=? and password=?");
	             pstatement.setString(1,userName);
	             pstatement.setString(2,password);
	             resultSet=pstatement.executeQuery();
	             
	            while(resultSet.next())
	    		{
	    			if(userName.equals(resultSet.getString("username"))&&password.equals(resultSet.getString("password")))
	    			{
	    				USER_TYPE=resultSet.getString("type");
	    				user.setId(resultSet.getInt("id"));
	    				user.setName(resultSet.getString("name"));
	    				user.setUsername(resultSet.getString("username"));
	    				user.setPassword(resultSet.getString("password"));
	    				user.setType(resultSet.getString("type"));
	    				user.setStatusMsg("success");
	    				System.out.println("SignUp Successful..!!");
	    				return user;
	    				
	    			}
	    			else
	    			{
	    				if(!resultSet.next())
	    			    {System.out.println("Login Failed..!!");}
	    				else
	    				{continue;}
	    				user.setStatusMsg("Failed");
	    			}
	    		}
		   }
		   catch(Exception e)
		   {System.out.println(e);}
		   
		return user;
	            
	   }
	        
}



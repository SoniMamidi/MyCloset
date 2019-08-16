package com.DBProjectCloset.controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/ItemUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
             maxFileSize=1024*1024*10,      // 10MB
             maxRequestSize=1024*1024*50)
public class ItemUploadServlet extends HttpServlet{ 
	private static final String SAVE_DIR="images";
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	        String savePath = "D:"+File.separator +"DBimages"; //specify your path here
	            File fileSaveDir=new File(savePath);
	            if(!fileSaveDir.exists()){
	                fileSaveDir.mkdir();
	            }

	        Part part=request.getPart("img-0");
	        String fileName=extractFileName(part);
	        part.write(savePath + File.separator + fileName);
	        String filePath= savePath + File.separator + fileName ;
	        out.print(filePath);
	       /* 
	        //You need this loop if you submitted more than one file
	        for (Part part : request.getParts()) {
	        String fileName = extractFileName(part);
	        part.write(savePath + File.separator + fileName);
	    }*/
	      //you can change this part acc. to your requirements
	      /*  try {
				Class.forName("com.mysql.jdbc.Driver");
			
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:2033/spartansdb","root","krishnateja");
	        String query="INSERT INTO table_name(file) values (?)";
          //Above query for updating item image upload location in database
	            PreparedStatement pst;
	            pst=con.prepareStatement(query);

	            String filePath= "Images" + File.separator + fileName ;
	            pst.setString(1,filePath);
	            pst.executeUpdate();
	        } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	}
	// file name of the upload file is included in content-disposition header like this:
	//form-data; name="dataFile"; filename="PHOTO.JPG"
	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    return "";
	}
}

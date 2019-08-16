package com.DBProjectCloset.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBProjectCloset.dao.AuthenticationDao;
import com.DBProjectCloset.dao.CustomerDao;
import com.DBProjectCloset.dao.GetItemsDao;
import com.DBProjectCloset.model.Address;
import com.DBProjectCloset.model.Items;
import com.DBProjectCloset.model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Items> itemsList=new ArrayList<Items>(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag=false;
		int status=0;
		CustomerDao dao=new CustomerDao();
		 HttpSession session=request.getSession();
		 String connection=request.getParameter("connection");  
	     String newsSubscription=request.getParameter("newsSubscription");
	     System.out.println(newsSubscription);
	     User user=(User) session.getAttribute("user");
	     int id=user.getId();
	     if(newsSubscription.equalsIgnoreCase("true")){
	    	 flag=true;
	     }
	     else if(newsSubscription.equalsIgnoreCase("false")){
	    	 flag=false;
	     }
	     status=dao.customer_update(id, connection,flag);
	     if(status>0){
	    	 GetItemsDao dao1=new GetItemsDao();
		     itemsList=dao1.getItems(true);
				request.setAttribute("Items", itemsList);
	    	 request.getRequestDispatcher("home.jsp").forward(request, response);
	     }
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int status=0;
		 String fName=request.getParameter("fullName");  
	     String userName=request.getParameter("userName");
	     String email=request.getParameter("email");
	     String phoneNo=request.getParameter("phoneNo");
	     String addressLine=request.getParameter("addressLine");
	     String city=request.getParameter("city");
	     String state=request.getParameter("state");
	     String postalCode=request.getParameter("postalCode");
	     String password=request.getParameter("password");
	     HttpSession session=request.getSession();
	     Address address=new Address(addressLine,postalCode,city,state);
	     User user=new User(fName,userName,password,"customer",email,phoneNo);
	     AuthenticationDao dao=new AuthenticationDao();
	     status=dao.signup_check(user,address);
	     
	     if(status>0){
	    	 User signeduser=dao.login_Check(user.getUsername(), user.getPassword());
	    	 session.setAttribute("user",signeduser);
	    	 request.getRequestDispatcher("setup.jsp").forward(request, response);
	     }
	     else{
	    	 request.getRequestDispatcher("authentication.jsp").forward(request, response);
	     }
	}

}

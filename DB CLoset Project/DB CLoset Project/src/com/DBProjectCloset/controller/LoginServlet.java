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
import com.DBProjectCloset.dao.GetItemsDao;
import com.DBProjectCloset.dao.OrderDetailsDao;
import com.DBProjectCloset.model.Items;
import com.DBProjectCloset.model.Order;
import com.DBProjectCloset.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	 ArrayList<Items> itemsList=new ArrayList<Items>();

	 ArrayList<Items> unapprovedList=new ArrayList<Items>();
	 ArrayList<Order> ordersList=new ArrayList<Order>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		 String password=request.getParameter("ePassword");
		 AuthenticationDao auDao=new AuthenticationDao();
		 User user=auDao.login_Check(username,password);
		 if(user.getStatusMsg().equalsIgnoreCase("success")){
			   session.setAttribute("user", user);
			   GetItemsDao dao=new GetItemsDao();
			   OrderDetailsDao dao1=new OrderDetailsDao();
				itemsList=dao.getItems(true);
				request.setAttribute("Items", itemsList);
				if(user.getType().equalsIgnoreCase("Admin")){
					ordersList=dao1.getOrders();
					unapprovedList=dao.getUnApprovedItems(false);
					request.setAttribute("Orders", ordersList);
					request.setAttribute("UnapprovedList", unapprovedList);
					request.getRequestDispatcher("admin.jsp").forward(request, response);
					
				}
				else if(user.getType().equalsIgnoreCase("Customer")){
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				
		 }
		 else if(user.getStatusMsg().equalsIgnoreCase("failed")){
			   request.getRequestDispatcher("authentication.jsp").forward(request, response);
		 }
	}

}

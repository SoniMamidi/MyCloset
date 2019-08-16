package com.DBProjectCloset.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBProjectCloset.dao.CartDao;
import com.DBProjectCloset.model.CartItem;
import com.DBProjectCloset.model.User;

/**
 * Servlet implementation class GoToCheckout
 */
@WebServlet("/GoToCheckout")
public class GoToCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<CartItem> cartItems=new ArrayList<CartItem>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		CartDao dao=new CartDao();
		cartItems=dao.getCartItems(user.getId());
		request.setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

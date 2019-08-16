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
import com.DBProjectCloset.dao.CartDeleteDao;
import com.DBProjectCloset.dao.CustomerOrdersDao;
import com.DBProjectCloset.dao.ItemsUpdateDao;
import com.DBProjectCloset.dao.OrdersDao;
import com.DBProjectCloset.model.CartItem;
import com.DBProjectCloset.model.Order;
import com.DBProjectCloset.model.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		CustomerOrdersDao dao3=new CustomerOrdersDao();
		ArrayList<Order> ordersList=dao3.getOrders(user.getId());
		request.setAttribute("OrdersList", ordersList);
		request.getRequestDispatcher("PurchaseHistory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(); 
		User user=(User) session.getAttribute("user");
		double tax=Double.parseDouble(request.getParameter("tax"));
		int shipping=Integer.parseInt(request.getParameter("shipping"));
		double product_total=Double.parseDouble(request.getParameter("product_total"));
		int cart_count=Integer.parseInt(request.getParameter("cart_count"));
		ArrayList<CartItem> itemList=new ArrayList<CartItem>();
		CartDao dao1=new CartDao();
		itemList=dao1.getCartItems(user.getId());
		OrdersDao dao=new OrdersDao();
		int status=dao.place_order(itemList, product_total, tax, shipping,user.getId());
		CartDeleteDao dao2=new CartDeleteDao();
		dao2.delete_cart(user.getId());
		CustomerOrdersDao dao3=new CustomerOrdersDao();
		ArrayList<Order> ordersList=dao3.getOrders(user.getId());
		request.setAttribute("success", true);
		request.setAttribute("OrdersList", ordersList);
		for(int i=0;i<itemList.size();i++)
		{
		ItemsUpdateDao dao4=new ItemsUpdateDao();
		dao4.update_itemSold(itemList.get(i));
		}
		request.getRequestDispatcher("PurchaseHistory.jsp").forward(request, response);
	}

}

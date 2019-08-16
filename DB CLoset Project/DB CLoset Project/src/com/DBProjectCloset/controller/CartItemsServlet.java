package com.DBProjectCloset.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class CartItemsServlet
 */
@WebServlet("/CartItemsServlet")
public class CartItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ArrayList<CartItem> cartItems=new ArrayList<CartItem>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		CartDao dao=new CartDao();
		cartItems=dao.getCartItems(user.getId());
		String cartList="";
		for(int i=0;i<cartItems.size();i++){
			CartItem itemC=cartItems.get(i);
			String cItemContainer="<div class='col-md-12 col-xs-12 cartItem'><div class='cartImg col-md-4 col-xs-12'><img src='"+itemC.getImgURl()+"'></div><div class='cartItemData col-md-8 col-xs-12'><div class='icName'>"+ itemC.getItemName()+"</div><div class='icPrice'>"+  itemC.getItemPrice()+"</div></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
			cartList=cartList+cItemContainer;
		}
		out.print(cartList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		CartDao dao=new CartDao();
		CartItem cartItem=new CartItem();
		cartItem.setItemName(request.getParameter("iName"));
		cartItem.setItemPrice(Double.parseDouble(request.getParameter("iPrice")));
		cartItem.setImgURl(request.getParameter("iImgUrl"));
		cartItem.setItemid(Integer.parseInt(request.getParameter("iItemID")));
		cartItem.setCustomerID(user.getId());
		int status=dao.insert_cart(cartItem);
		cartItems=dao.getCartItems(user.getId());
		String cartList="";
		for(int i=0;i<cartItems.size();i++){
			CartItem itemC=cartItems.get(i);
			String cItemContainer="<div class='col-md-12 col-xs-12 cartItem'><div class='cartImg col-md-4 col-xs-12'><img src='"+itemC.getImgURl()+"'></div><div class='cartItemData col-md-8 col-xs-12'><div class='icName'>"+ itemC.getItemName()+"</div><div class='icPrice'>"+  itemC.getItemPrice()+"</div></div><div class='clear_fix'></div></div><div class='clear_fix'></div>";
			cartList=cartList+cItemContainer;
		}
		out.print(cartList);
	}

}

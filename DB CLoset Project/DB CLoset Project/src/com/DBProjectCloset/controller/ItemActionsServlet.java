package com.DBProjectCloset.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBProjectCloset.dao.DeleteItemDao;
import com.DBProjectCloset.dao.ItemApproveDao;
import com.DBProjectCloset.dao.ItemDetailDao;
import com.DBProjectCloset.model.Items;
import com.DBProjectCloset.model.User;

/**
 * Servlet implementation class ItemActionsServlet
 */
@WebServlet("/ItemActionsServlet")
public class ItemActionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemActionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		int itemID=Integer.parseInt(request.getParameter("itemID"));
		ItemDetailDao dao1=new ItemDetailDao();
		Items item=dao1.getItem(itemID);
		ItemApproveDao dao=new ItemApproveDao();
		String message="<html><div style='background: #eee;padding: 10px;border-radius:5px;width:100%'><h3 style='color:#333;'>Your Tax Document For "+ item.getName()+"</h3><div style='margin-top:20px;border-top:1px solid #ccc;padding-top:10px;color:#666'>This is to confirm that your item has been taken into our closet. Thanks for donating and here is the tax document worth"+item.getItemprice()+"$</div></div></html>";
		int status=dao.update_item(item.getItemid(),item.getCustomer_id(),message,item.getUser(item.getCustomer_id()).getEmail());
		if(status>0){
			out.print("<div>Item is approved and sent to shopping list <span class='glyphicon glyphicon-ok'></span></div>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int itemID=Integer.parseInt(request.getParameter("itemID"));
		DeleteItemDao dao=new DeleteItemDao();
		int status=dao.delete_Item(itemID);
		
	}

}

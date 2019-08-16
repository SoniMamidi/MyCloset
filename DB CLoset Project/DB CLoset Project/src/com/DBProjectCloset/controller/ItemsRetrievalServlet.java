package com.DBProjectCloset.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBProjectCloset.dao.GetItemsDao;
import com.DBProjectCloset.model.Items;

/**
 * Servlet implementation class ItemsRetrievalServlet
 */
@WebServlet("/ItemsRetrievalServlet")
public class ItemsRetrievalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ArrayList<Items> itemsList=new ArrayList<Items>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsRetrievalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetItemsDao dao=new GetItemsDao();
		itemsList=dao.getItems(true);
		request.setAttribute("Items", itemsList);
		request.getRequestDispatcher("home.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

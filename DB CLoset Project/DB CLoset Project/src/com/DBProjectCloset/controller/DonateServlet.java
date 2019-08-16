package com.DBProjectCloset.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBProjectCloset.dao.GetItemsDao;
import com.DBProjectCloset.dao.ItemUploadDao;
import com.DBProjectCloset.model.Items;
import com.DBProjectCloset.model.User;
/**
 * Servlet implementation class DonateServlet
 */
@WebServlet("/DonateServlet")
public class DonateServlet extends HttpServlet {

    ArrayList<Items> itemsList=new ArrayList<Items>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("donate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat date=new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
		HttpSession session=request.getSession(); 
		 User user=(User) session.getAttribute("user");
		String name=request.getParameter("item-name");
		String gender=request.getParameter("gender");
		String size=request.getParameter("item-size");
		String color=request.getParameter("item-color");
		String brand=request.getParameter("item-brand");
		String quantity=request.getParameter("item-quantity");
		double price=Double.parseDouble(request.getParameter("item-price"));
		String imgURL=request.getParameter("imgURL");
		String description=request.getParameter("description");
		String category=request.getParameter("item-category");
		String age=request.getParameter("item-age");
		String showDetails=request.getParameter("showDetails");
		Items item=new Items();
	       item.setItemprice(price);
		   item.setCategory(category);
		   item.setName(name);
		   item.setDescription(description);
		   item.setImagebrand(brand);
		   item.setSize(size);
		   item.setColor(color);
		   item.setItemAge(age);
		   item.setImageurl(imgURL);
		   item.setGender(gender);
		   item.setQuantity(quantity);
		   item.setCustomer_id(user.getId());
		   item.setRequested_price(price);
		   item.setDonorstatus(showDetails);
		   item.setIsapproved(false);
		   item.setApproved_by("");
		   item.setDate_posted(date.format(new Date()));
		   item.setDiscount(0.0);
		   item.setIssold(false);
		   ItemUploadDao items=new ItemUploadDao();
		   int status=items.set_item(item);
		   if(status>0){
			   GetItemsDao dao=new GetItemsDao();
				itemsList=dao.getItems(true);
				request.setAttribute("Items", itemsList);
				request.getRequestDispatcher("home.jsp").forward(request, response);
		   }
	}

}

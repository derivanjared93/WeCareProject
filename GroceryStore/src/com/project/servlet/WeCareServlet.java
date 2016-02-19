package com.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.exception.CustomException;
import com.project.exception.WrongEntryException;
import com.project.pojo.Food;
import com.project.service.CustomerService;
import com.project.service.CustomerServiceImplMySql;
import com.project.service.FoodService;
import com.project.service.FoodServiceImplMySql;

/**
 * Servlet implementation class WeCareServlet
 */
@WebServlet("/WeCareServlet")
public class WeCareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_PAGE = "/jsp/error.jsp";   
	private static final String CHECKOUT_PAGE = "/jsp/checkout.jsp";
	private static final String SHOPPING_CART_PAGE = "/jsp/cart.jsp";
	private static final String CATALOG_PAGE = "/jsp/catalog.jsp";
	CustomerService custService = new CustomerServiceImplMySql();
	FoodService foodService = new FoodServiceImplMySql();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeCareServlet() {super();}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String forwardView = ERROR_PAGE;
		if(action != null && action.equals("checkout"))
		{
			forwardView = CHECKOUT_PAGE;
		}
		else if(action != null && action.equals("cart"))
		{
			forwardView = SHOPPING_CART_PAGE;
		}
		else if(action != null && action.equals("catalog"))
		{
			try 
			{
				List<Food> foodList = foodService.getAllFood();
				request.setAttribute("list_food", foodList);

				forwardView = CATALOG_PAGE;
			} 
			catch (CustomException e){e.printStackTrace();} 
			catch (WrongEntryException e){e.printStackTrace();}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(forwardView);
		try 
		{
			dispatch.forward(request, response);
		} 
		catch (ServletException e) 	{e.printStackTrace();} 
		catch (IOException e) 		{e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

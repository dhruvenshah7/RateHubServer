package com.controller.restaurantCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.RestaurantCategoryBean;
import com.dao.RestaurantCategoryDao;

/**
 * Servlet implementation class RestaurantCategoryViewController
 */
@WebServlet("/RestaurantCategoryViewController")
public class RestaurantCategoryViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantCategoryViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("tid");
		
		RestaurantCategoryBean bean = RestaurantCategoryDao.getData(id);
		
		if (bean != null) {
			
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("viewPage.jsp").forward(request, response);
			
		} else {
			
			request.getRequestDispatcher("listPage.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

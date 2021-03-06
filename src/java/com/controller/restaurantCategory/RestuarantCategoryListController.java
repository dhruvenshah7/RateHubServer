package com.controller.restaurantCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.beans.RestaurantCategoryBean;

import com.dao.RestaurantCategoryDao;

/**
 * Servlet implementation class RestuarantCategoryListController
 */
@WebServlet("/RestuarantCategoryListController")
public class RestuarantCategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestuarantCategoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<RestaurantCategoryBean> list = new ArrayList<RestaurantCategoryBean>();

		RestaurantCategoryDao dao = new RestaurantCategoryDao();
		list = dao.listData();

		if (list != null) {
			request.setAttribute("list", list);
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

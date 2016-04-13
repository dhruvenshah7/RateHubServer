package com.controller.restaurantMaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.RestaurantMasterBean;

import com.dao.RestaurantMasterDao;


/**
 * Servlet implementation class RestaurantEditController
 */
@WebServlet("/RestaurantEditController")
public class RestaurantEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantEditController() {
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

		RestaurantMasterDao dao = new RestaurantMasterDao();
		RestaurantMasterBean bean = dao.editData(id);

		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("editPage.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("ListController").forward(request, response);
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

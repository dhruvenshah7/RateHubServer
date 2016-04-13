package com.controller.dishMaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DishMasterBean;
import com.dao.DishMasterDao;

/**
 * Servlet implementation class DishMasterViewController
 */
@WebServlet("/DishMasterViewController")
public class DishMasterViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DishMasterViewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println(" view controller call");
		String dishId = request.getParameter("dishId");
		System.out.println(dishId);

		DishMasterDao dao = new DishMasterDao();
		DishMasterBean bean = dao.getData(Integer.parseInt(dishId));

		if (bean != null)

		{
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("stateView.jsp").forward(request, response);

		} else {
			response.sendRedirect("StateListController");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

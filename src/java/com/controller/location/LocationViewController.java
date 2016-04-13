package com.controller.location;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.LocationMasterBean;
import com.dao.LocationMasterDao;

/**
 * Servlet implementation class LocationViewController
 */
@WebServlet("/LocationViewController")
public class LocationViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocationViewController() {
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
		String restId = request.getParameter("restId");
		System.out.println(restId);

		LocationMasterDao dao = new LocationMasterDao();
		LocationMasterBean bean = dao.getData(Integer.parseInt(restId));

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

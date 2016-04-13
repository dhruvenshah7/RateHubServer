package com.controller.dishMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DishMasterBean;
import com.dao.DishMasterDao;

/**
 * Servlet implementation class DishMasterListController
 */
@WebServlet("/DishMasterListController")
public class DishMasterListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DishMasterListController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		List<DishMasterBean> list = new ArrayList<DishMasterBean>();

		DishMasterDao dao = new DishMasterDao();

		list = dao.listData();

		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("stateList.jsp").forward(request, response);
		} else {
			response.sendRedirect("stateInsert.jsp");
		}
	}

}

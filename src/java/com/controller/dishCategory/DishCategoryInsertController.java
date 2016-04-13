package com.controller.dishCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.DishCategoryBean;

import com.dao.DishCategoryDao;


/**
 * Servlet implementation class DishCategoryInsertController
 */
@WebServlet("/DishCategoryInsertController")
public class DishCategoryInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishCategoryInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String dishCategory = request.getParameter("dishCategory");
		
		
		DishCategoryBean bean = new DishCategoryBean();
		bean.setDishCategory(dishCategory);

		DishCategoryDao dao = new DishCategoryDao();
		boolean flag = dao.insertData(bean);

		if (flag) {
			request.getRequestDispatcher("ListController").forward(request, response);

		} else {

			response.sendRedirect("insertPage.jsp");

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

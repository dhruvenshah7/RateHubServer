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
 * Servlet implementation class DishCategoryUpdateController
 */
@WebServlet("/DishCategoryUpdateController")
public class DishCategoryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishCategoryUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String dishCatId = request.getParameter("dishCatId");
		String dishCategory = request.getParameter("dishCategory");

		DishCategoryBean bean = new DishCategoryBean();
		bean.setDishCatId(Integer.parseInt(dishCatId));
		bean.setDishCategory(dishCategory);

		DishCategoryDao dao = new DishCategoryDao();
		boolean flag = dao.updateData(bean);

		if (flag) {
			response.sendRedirect("ListController");

		} else {

			response.sendRedirect("ListController");

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

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
 * Servlet implementation class RestaurantInsertController
 */
@WebServlet("/RestaurantInsertController")
public class RestaurantInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String restId = request.getParameter("restId");
		String restName = request.getParameter("restName");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String provience = request.getParameter("provience");
		String postalCode = request.getParameter("postalCode");
		
		RestaurantMasterBean bean = new RestaurantMasterBean();
		bean.setRestId(Integer.parseInt(restId));
		bean.setRestName(restName);
		bean.setStreet(street);
		bean.setCity(city);
		bean.setProvience(provience);
		bean.setPostalCode(postalCode);

		RestaurantMasterDao dao = new RestaurantMasterDao();
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

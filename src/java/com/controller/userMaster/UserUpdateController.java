package com.controller.userMaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserMasterBean;
import com.dao.UserMasterDao;

/**
 * Servlet implementation class UserUpdateController
 */
@WebServlet("/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateController() {
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

		String id = request.getParameter("id");
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserMasterBean bean = new UserMasterBean();
		bean.setuId(Integer.parseInt(id));
		bean.setfName(fName);
		bean.setlName(lName);
		bean.setEmail(email);
		bean.setPassword(password);

		UserMasterDao dao = new UserMasterDao();
		boolean flag = dao.updateData(bean);

		if (flag) {
			response.sendRedirect("ListController");

		} else {

			response.sendRedirect("ListController");

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

package com.controller.userMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserMasterBean;
import com.dao.UserMasterDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListController() {
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

		List<UserMasterBean> list = new ArrayList<UserMasterBean>();

		UserMasterDao dao = new UserMasterDao();
		list = dao.listData();

		if (list != null) {
			request.setAttribute("list", list);
			// request.getRequestDispatcher("listPage.jsp").forward(request,
			// response);

			for (int i = 0; i < list.size(); i++) {
				UserMasterBean bean = (UserMasterBean) list.get(i);
				System.out.println(bean.getfName());
				System.out.println(bean.getlName());
				System.out.println(bean.getEmail());
				System.out.println(bean.getPassword());
			}

			String json = new Gson().toJson(list);
			System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

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

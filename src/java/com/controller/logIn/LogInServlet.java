package com.controller.logIn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserMasterBean;
import com.dao.LogInDao;
import org.json.simple.JSONObject;



/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
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
		
		System.out.println("Call");
		Enumeration paramNames = request.getParameterNames();
		String params[] = new String[2];
		int i = 0;
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();

			// System.out.println(paramName);
			String[] paramValues = request.getParameterValues(paramName);
			params[i] = paramValues[0];

			// System.out.println(params[i]);
			i++;

		}

//		String username = request.getParameter("username");
//		String password = request.getParameter("password");

		// HttpSession session = request.getSession();
		// if(type.equals("Administrator")){
		UserMasterBean bean = null;

		bean = new LogInDao().AuthenticateUser(params[0], params[1]);

		JSONObject json = new JSONObject();

		if (bean != null) {

			json.put("Info","Success");

		} else {
			json.put("Info", "Fail");
		}
                response.getWriter().write(json.toString());
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

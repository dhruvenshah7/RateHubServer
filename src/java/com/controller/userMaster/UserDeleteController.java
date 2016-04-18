package com.controller.userMaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserMasterDao;
import java.util.Enumeration;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
       // response.getWriter().append("Served at: ").append(request.getContextPath());

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
        UserMasterDao dao = new UserMasterDao();
        boolean flag = dao.deleteData(params[0]);
        
        JSONObject json = new JSONObject();

        if (flag) {
            json.put("Info", "Success");

        } else {

            json.put("Info", "Fail");

        }
        response.getWriter().write(json.toString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

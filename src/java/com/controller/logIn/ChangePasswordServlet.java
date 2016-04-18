package com.controller.logIn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserMasterBean;
import com.dao.UserMasterDao;
import java.util.Enumeration;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
        //	response.getWriter().append("Served at: ").append(request.getContextPath());

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

        UserMasterBean bean = new UserMasterBean();

        bean.setEmail(params[0]);
        bean.setPassword(params[1]);

        UserMasterDao dao = new UserMasterDao();
        //boolean flag = dao.changePass(bean);

        JSONObject json = new JSONObject();
        boolean b = dao.checkEmail(params[0]);

        if (b) {

            json.put("emailChk", "Success");

            System.out.println("emal true");
            boolean flag = dao.changePass(bean);

            if (flag) {
                json.put("Info", "Success");

            } else {

                json.put("Info", "Fail");

            }

        } else {
            json.put("emailChk", "fail");
            json.put("Info", "Fail");
            System.out.println("email fail");

        }
        response.getWriter().write(json.toString());
        System.out.println(json.toString());

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

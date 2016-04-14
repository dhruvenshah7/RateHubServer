package com.controller.userMaster;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.UserMasterBean;
import com.dao.UserMasterDao;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class UserInsertController
 */
@WebServlet("/UserInsertController")
public class UserInsertController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertController() {
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
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        String fName = request.getParameter("first_name");
        String lName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserMasterBean bean = new UserMasterBean();
        bean.setfName(fName);
        bean.setlName(lName);
        bean.setEmail(email);
        bean.setPassword(password);

        UserMasterDao dao = new UserMasterDao();
        boolean flag = dao.insertData(bean);

        JSONObject json = new JSONObject();

        if (flag) {
            json.put("Info", "Success");
            json.put("First_Name", fName);

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

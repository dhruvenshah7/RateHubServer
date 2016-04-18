package com.controller.restaurantMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.RestaurantMasterBean;
import com.dao.RestaurantMasterDao;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class RestaurantListController
 */
@WebServlet("/RestaurantListController")
public class RestaurantListController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantListController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        List<RestaurantMasterBean> list = new ArrayList<RestaurantMasterBean>();
        List<String> alist= new ArrayList<String>();
        JSONArray jarray = new JSONArray();
        JSONObject j = new JSONObject();

        RestaurantMasterDao dao = new RestaurantMasterDao();
        alist = dao.listData();

//alist.add("Dhara");
//alist.add("Fountain");
//alist.add("Palak");
//alist.add("Sai Palace");

//        if (j != null) {
            String json = new Gson().toJson(alist);
           // JSONObject json =new JSONObject();
//            json.put("Name", "Shahi");
//            json.put("Speciality","Chicken");
  //         System.out.println(json);
response.setContentType("application/json");
          response.setCharacterEncoding("UTF-8");
         
response.getWriter().write(json);

  //      }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.RestaurantMasterBean;
import com.google.gson.JsonArray;
import com.util.SqlConnection;
import org.json.simple.JSONObject;

public class RestaurantMasterDao {
    public static void main(String[] args) {
        RestaurantMasterDao dao = new RestaurantMasterDao();
        
        System.out.println(dao.listData());
    }
    public boolean deleteData(String id) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;

        conn = SqlConnection.getConnection();

        if (conn != null) {

            String sql = "delete from RASTAURANT_MASTER where id = " + id;

            try {
                stmt = conn.createStatement();
                int result = stmt.executeUpdate(sql);

                if (result > 0) {

                    flag = true;
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }

        } else {

            System.out.println(" Connection Problem.....");
        }

        return flag;
    }

    public RestaurantMasterBean editData(String id) {
        // TODO Auto-generated method stub
        RestaurantMasterBean bean = new RestaurantMasterBean();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = SqlConnection.getConnection();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from RESTAURANT_MASTER where id = " + id);

            while (rs.next()) {

                bean.setRestId(rs.getInt("RestId"));
                bean.setRestName(rs.getString("RestName"));
                bean.setStreet(rs.getString("Street"));
                bean.setCity(rs.getString("City"));
                bean.setProvience(rs.getString("Provience"));
                bean.setPostalCode(rs.getString("PostalCode"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public boolean insertData(RestaurantMasterBean bean) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = SqlConnection.getConnection();

        if (conn != null) {

            String sql = "insert into USER_MASTER(restName,street,city,province,postalCode) values (?,?,?,?,?)";

            try {

                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, bean.getRestName());
                pstmt.setString(2, bean.getStreet());
                pstmt.setString(3, bean.getCity());
                pstmt.setString(4, bean.getProvience());
                pstmt.setString(5, bean.getPostalCode());

                int result = pstmt.executeUpdate();

                if (result != 0) {

                    flag = true;
                }
            } catch (SQLException e) {

                e.printStackTrace();
            } finally {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } else {

            System.out.println("Connection Problem.....");
        }

        return flag;
    }

    public List<String> listData() {
        // TODO Auto-generated method stub

        List<RestaurantMasterBean> list = new ArrayList<RestaurantMasterBean>();

        JSONObject json = null;

        JsonArray jarray = new JsonArray();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
 List<String> alist = null;
        conn = SqlConnection.getConnection();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from RESTAURANT_MASTER");

            RestaurantMasterBean bean = null;
            
             alist = new ArrayList<String>();

            while (rs.next()) {

                alist.add(rs.getString("rest_name"));
//                bean = new RestaurantMasterBean();
//                json = new JSONObject();
//
//                json.put("id", rs.getInt("rest_id"));
//                json.put("name", rs.getString("rest_name"));
//
//                bean.setRestId(rs.getInt("rest_id"));
//                System.out.println(rs.getInt("rest_id"));
//                
//                bean.setRestName(rs.getString("rest_name"));
////                bean.setStreet(rs.getString("Street"));
////                bean.setCity(rs.getString("City"));
////                bean.setProvience(rs.getString("Provience"));
////                bean.setPostalCode(rs.getString("PostalCode"));
//
//                list.add(rs.getInt("rest_id"));
 //               jarray.add(jarray);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alist;
    }

    public boolean updateData(RestaurantMasterBean bean) {
        // TODO Auto-generated method stub
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;

        conn = SqlConnection.getConnection();

        try {

            stmt = conn.createStatement();

            String updateSQL = "update RESTAURANT_MASSTER set RestName='" + bean.getRestName() + "',Street='"
                    + bean.getStreet() + "',City='" + bean.getCity() + "',Provience='" + bean.getProvience()
                    + "',PostalCode='" + bean.getPostalCode() + "' where user_id = '" + bean.getRestId() + "'";

            System.out.println(updateSQL);
            int result = stmt.executeUpdate(updateSQL);

            if (result > 0) {
                flag = true;

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return flag;
    }

}

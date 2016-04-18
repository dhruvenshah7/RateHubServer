package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.UserMasterBean;
import com.util.SqlConnection;

public class UserMasterDao {

    public static void main(String[] args) {
        UserMasterDao dao= new UserMasterDao();
        UserMasterBean bean =new UserMasterBean();
        bean.setEmail("nirat.joshi32@gmail.com");
        bean.setPassword("abcd");
        dao.changePass(bean);
    }
    public boolean insertData(UserMasterBean bean) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = SqlConnection.getConnection();

        if (conn != null) {

            String sql = "insert into USER_MASTER(first_name,last_name,email_id,password) values (?,?,?,?)";

            try {

                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, bean.getfName());
                pstmt.setString(2, bean.getlName());
                pstmt.setString(3, bean.getEmail());
                pstmt.setString(4, bean.getPassword());

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

    public List<UserMasterBean> listData() {
        // TODO Auto-generated method stub
        List<UserMasterBean> list = new ArrayList<UserMasterBean>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = SqlConnection.getConnection();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from USER_MASTER");

            UserMasterBean bean = null;

            while (rs.next()) {

                bean = new UserMasterBean();

                bean.setuId(rs.getInt("user_id"));
                bean.setfName(rs.getString("first_name"));
                bean.setlName(rs.getString("last_name"));
                bean.setEmail(rs.getString("email_id"));
                bean.setPassword(rs.getString("password"));

                list.add(bean);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean deleteData(String id) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;

        conn = SqlConnection.getConnection();

        if (conn != null) {

            String sql = "delete from USER_MASTER where email_id = '" + id+"'";

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

    public UserMasterBean editData(String id) {
        // TODO Auto-generated method stub

        UserMasterBean bean = new UserMasterBean();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = SqlConnection.getConnection();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from USER_MASTER where id = " + id);

            while (rs.next()) {

                bean.setuId(rs.getInt("user_id"));
                bean.setfName(rs.getString("first_name"));
                bean.setlName(rs.getString("last_name"));
                bean.setEmail(rs.getString("email_id"));
                bean.setPassword(rs.getString("password+"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public boolean updateData(UserMasterBean bean) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;

        conn = SqlConnection.getConnection();

        try {

            stmt = conn.createStatement();

            String updateSQL = "update USER_MASTER set first_name='" + bean.getfName() + "',last_name='"
                    + bean.getlName() + "',email_id='" + bean.getEmail() + "',password='" + bean.getPassword()
                    + "' where user_id = '" + bean.getuId() + "'";

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

    public boolean checkEmail(String email) {
        // TODO Auto-generated method stub

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count;
        boolean flag = false;

        conn = SqlConnection.getConnection();

        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select count(*) from USER_MASTER where email_id = '" + email + "'");

            while (rs.next()) {

                count = rs.getInt(1);
                if (count > 0) {
                    flag = true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean changePass(UserMasterBean bean) {
        // TODO Auto-generated method stub

        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;

        conn = SqlConnection.getConnection();

        try {

            stmt = conn.createStatement();

            String updateSQL = "update USER_MASTER set password='" + bean.getPassword()
                    + "' where email_id = '" + bean.getEmail() + "'";

            System.out.println(updateSQL);
            int result = stmt.executeUpdate(updateSQL);

            if (result > 0) {
                flag = true;
                System.out.println("true");

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return flag;

    }

}

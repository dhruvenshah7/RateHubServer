package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.beans.UserMasterBean;
import com.util.SqlConnection;

public class LogInDao {

	public UserMasterBean AuthenticateUser(String username, String password) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = SqlConnection.getConnection();

		if (conn != null) {

			String queryuser = "select * from USER_MASTER where email_id = ? and password = ? ";
			try {
				pstmt = conn.prepareStatement(queryuser);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();

				UserMasterBean userBean = null;

				while (rs.next()) {
					userBean = new UserMasterBean();

					userBean.setuId(rs.getInt("userid"));
					userBean.setfName(rs.getString("first_name"));
					userBean.setlName(rs.getString("last_name"));
					userBean.setEmail(rs.getString("email_id"));
					userBean.setPassword(rs.getString("password"));

					return userBean;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	}

}

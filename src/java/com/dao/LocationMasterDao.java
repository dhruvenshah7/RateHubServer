package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.LocationMasterBean;
import com.util.SqlConnection;

public class LocationMasterDao {

	public LocationMasterBean getData(int restId) {
		// TODO Auto-generated method stub
		System.out.println("get Data method call.....");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		LocationMasterBean bean = new LocationMasterBean();
		conn = SqlConnection.getConnection();

		if (conn != null) {
			try {
				System.out.println(restId);
				String viewSQL = ""; // select state.stateid, state.statename,
										// country.countryname,
										// country.countryid from state inner
										// join country on country.countryid =
										// state.countryid where stateid = ?
				pstmt = conn.prepareStatement(viewSQL);
				pstmt.setInt(1, restId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setLocId(rs.getInt("location_id"));
					bean.setLongitude(rs.getString("longitude"));
					bean.setLatitude(rs.getString("latitude"));
					bean.setRestId(rs.getInt("rest_id"));
				}

				System.out.println("while completed");

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return bean;
	}

}

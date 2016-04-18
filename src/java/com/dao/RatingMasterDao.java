/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.beans.DishMasterBean;
import com.beans.RatingMasterBean;
import com.util.SqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rohan
 */
public class RatingMasterDao {
    
    public RatingMasterBean getData(int dishId) {
		// TODO Auto-generated method stub
		System.out.println("get Data method call.....");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		RatingMasterBean bean = new RatingMasterBean();
		conn = SqlConnection.getConnection();

		if (conn != null) {
			try {
				System.out.println(dishId);
				String viewSQL = "select rating from rating_master where dish_id = ?"; // select state.stateid, state.statename,
										// country.countryname,
										// country.countryid from state inner
										// join country on country.countryid =
										// state.countryid where stateid = ?
				pstmt = conn.prepareStatement(viewSQL);
				pstmt.setInt(1, dishId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					//bean.setDishId(rs.getInt("dish_id"));
					bean.setDishId(dishId);
					bean.setRating(rs.getString("rating"));
					//bean.setDishCatId(rs.getInt("dish_cat_id"));
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

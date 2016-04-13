package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.DishCategoryBean;
import com.util.SqlConnection;

public class DishCategoryDao {

	public boolean deleteData(String id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;

		conn = SqlConnection.getConnection();

		if (conn != null) {

			String sql = "delete from Dish_Category where id = " + id;

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

	public DishCategoryBean editData(String id) {
		// TODO Auto-generated method stub
		DishCategoryBean bean = new DishCategoryBean();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = SqlConnection.getConnection();

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from Dish_Category where id = " + id);

			while (rs.next()) {

				bean.setDishCatId(rs.getInt("DishCatId"));
				bean.setDishCategory(rs.getString("DishCategory"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public boolean insertData(DishCategoryBean bean) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = SqlConnection.getConnection();

		if (conn != null) {

			String sql = "insert into DISH_CATEEGORY(dish_category) values (?)";

			try {

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, bean.getDishCategory());

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

	public List<DishCategoryBean> listData() {
		// TODO Auto-generated method stub
		List<DishCategoryBean> list = new ArrayList<DishCategoryBean>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = SqlConnection.getConnection();

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from Dish_Category");

			DishCategoryBean bean = null;

			while (rs.next()) {

				bean = new DishCategoryBean();

				bean.setDishCatId(rs.getInt("dishCatId"));
				bean.setDishCategory(rs.getString("DishCategory"));

				list.add(bean);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateData(DishCategoryBean bean) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;

		conn = SqlConnection.getConnection();

		try {

			stmt = conn.createStatement();

			String updateSQL = "update DISH_CATEGORY set dish_category='" + bean.getDishCategory() + "'";

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

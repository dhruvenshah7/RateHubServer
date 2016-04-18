package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.DishMasterBean;
import com.util.SqlConnection;


public class DishMasterDao {

    public static void main(String[] args) {
        
        DishMasterDao dao = new DishMasterDao();
        dao.getData("Salmon");
    }
  
            
            
	public List<DishMasterBean> listData() {
		// TODO Auto-generated method stub

		List<DishMasterBean> list = new ArrayList<DishMasterBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = SqlConnection.getConnection();

		if (conn != null) {
			String listSQL = ""; // select state.stateid, state.statename,
									// country.countryname, country.countryid
									// from state inner join country on
									// country.countryid = state.countryid
			System.out.println(listSQL);
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				System.out.println("query execute....");
				DishMasterBean bean = null;

				while (rs.next()) {
					System.out.println("while call");
					bean = new DishMasterBean();

					bean.setDishId(rs.getInt("dish_id"));
					bean.setDishName(rs.getString("dish_name"));
					bean.setDeshDesc(rs.getString("dish_description"));
					bean.setDishCatId(rs.getInt("dish_cat_id"));

					list.add(bean);
					System.out.println("while executed");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		return list;
	}

	public DishMasterBean getData(String dishId) {
		// TODO Auto-generated method stub
		System.out.println("get Data method call.....");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DishMasterBean bean = new DishMasterBean();
		conn = SqlConnection.getConnection();

		if (conn != null) {
			try {
				System.out.println(dishId);
				String viewSQL = "select * from dish_master where dish_name = ?"; // select state.stateid, state.statename,
										// country.countryname,
										// country.countryid from state inner
										// join country on country.countryid =
										// state.countryid where stateid = ?
				pstmt = conn.prepareStatement(viewSQL);
				pstmt.setString(1, dishId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setDishId(rs.getInt("dish_id"));
					bean.setDishName(dishId);
					bean.setDeshDesc(rs.getString("dish_description"));
					//bean.setDishCatId(rs.getInt("dish_cat_id"));
                                        
                                        System.out.println(bean.getDishId());
                                        System.out.println(bean.getDishName());
                                        System.out.println(bean.getDeshDesc());
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

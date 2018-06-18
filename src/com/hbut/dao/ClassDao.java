package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class ClassDao {
	
	/**
	 * 返回所有班级
	 * @return
	 */
	public static ResultSet queryClass() {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "select ClassNO,Grade,Major,Ind from hbut_class ";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 根据班级号返回班级名称
	 * @param classNO
	 * @return
	 */
	public static String getClassName(String classNO) {
		String classString = "";
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM hbut_class "
				+"WHERE ClassNO =  '"+classNO +"' ";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
			while(rs != null && rs.next() ){
				classString = rs.getString("Grade")+rs.getString("Major")+"-"+rs.getInt("Ind");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classString;
	}

}

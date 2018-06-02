package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class StudentDao {
	
	public static String getClassName(String stuNO) throws SQLException{
		String classString = "";
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM hbut_class,hbut_student "
				+"WHERE hbut_class.ClassNO = hbut_student.ClassNO "
				+"AND StudentNO = '"+stuNO +"' ";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while(rs != null && rs.next() ){
			classString = rs.getString("Grade")+rs.getString("Major")+"-"+rs.getInt("Index");
		}
		return classString;
	}

}

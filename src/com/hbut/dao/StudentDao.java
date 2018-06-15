package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class StudentDao {
	
	public static String getClassNO(String stuNO){
		String classNO = "";
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT hbut_student.ClassNO AS ClassNO FROM hbut_class,hbut_student "
				+"WHERE hbut_class.ClassNO = hbut_student.ClassNO "
				+"AND StudentNO = '"+stuNO +"' ";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
			while(rs != null && rs.next() ){
				classNO = rs.getString("ClassNO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classNO;
	}

}

package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class TeacherDao {
	
	public static ResultSet queryTeacher(int weekNum,int section) {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "select TeacherNO,TeacherName from hbut_teacher WHERE TeacherNO NOT IN ( "
				+"SELECT TeacherNO FROM hbut_teachprogram WHERE Section = "
				+section+" AND WeekNum = "+weekNum +" )";
		try{
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
}

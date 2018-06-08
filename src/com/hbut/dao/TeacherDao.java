package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class TeacherDao {
	
	public static ResultSet queryTeacher() {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "select TeacherNO,TeacherName from hbut_teacher ";
		try{
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
}

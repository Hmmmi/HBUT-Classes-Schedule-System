package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class ClassDao {
	
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

}

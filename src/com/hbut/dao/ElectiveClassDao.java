package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.bean.ElectiveClass;
import com.hbut.util.ConnectSQL;

public class ElectiveClassDao {
	
	public static void saveElectiveClass(ElectiveClass ec){
		Connection conn = ConnectSQL.getConnection();
		String sql = "INSERT INTO hbut_electiveclass ("
				+ "SelectClassNO, CourseNO, TeacherNO, RoomNO, PeopleNum, "
				+ "StartWeek,endWeek,Section,WeekNum)"
				+ " VALUES ("
				+ "'"+ec.getSelectClassNO()+"', '"+ec.getCourseNO()+"', '"+ec.getTeacherNO()+"','"
				+ ec.getRoomNO()+"', "+ec.getPeopleNum()+","+ec.getStartWeek()+","+ec.getEndWeek()+","
				+ ec.getSection()+","+ec.getWeekNum()+" )";
		System.out.println("saveElectiveClass:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			// System.out.println(sql);
			int rs = pstate.executeUpdate();
			if (rs==1) {
				System.out.println("课程添加成功");
			}
		} catch (SQLException e1) {
			System.out.println("课程添加失败");
			e1.printStackTrace();
		}
	}
	
	public static ResultSet queryEelectiveClass() {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "select * from elective_class ";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}

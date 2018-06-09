package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.bean.TeachProgramBean;
import com.hbut.util.ConnectSQL;

public class TeachProgramDao {
	
	public static ResultSet teacherSchedule(String teacherNO){
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM teachschedule "
				+"WHERE TeacherNO = '"+teacherNO +"' "
				+"ORDER BY WeekNum,Section ASC";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet stuSchedule(String stuNO){
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM stuschedule  "
				+"WHERE StudentNO = '"+stuNO +"' "
				+"ORDER BY WeekNum,Section ASC";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void saveTeacheProgram(TeachProgramBean tp){
		Connection conn = ConnectSQL.getConnection();
		String sql = "INSERT INTO hbut_teachprogram ("
				+ "ProgramID, CourseNO, RoomNO, ClassNO, TeacherNO, "
				+ "StartWeek, endWeek, Section, WeekNum ) "
				+ " VALUES ("
				+ "'"+String.valueOf( tp.getProgramID() )+"', '"+tp.getCoureseNO()
				+ "', '"+tp.getRoomNO()+"', '"+tp.getClassNO()+"', '"+tp.getTeacherNO()
				+ "' ,  "+ tp.getStartWeek() + " ,  "+ tp.getEndWeek() + " ,  "+ tp.getSection()
				+ " ,  "+ tp.getWeekNum() +"  ) ";
		System.out.println("saveTeacheProgram:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			// System.out.println(sql);
			int rs = pstate.executeUpdate();
			if (rs==1) {
				System.out.println("教学计划添加成功");
			}
		} catch (SQLException e1) {
			System.out.println("教学计划添加失败");
			e1.printStackTrace();
		}
	}

}

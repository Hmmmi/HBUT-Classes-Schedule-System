package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.bean.TeachProgramBean;
import com.hbut.util.ConnectSQL;

public class TeachProgramDao {
	
	/**
	 * 查询教师教学信息
	 * @param teacherNO
	 * @return
	 */
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
	
	/**
	 * 返回某班教学信息
	 * @param classNO
	 * @return
	 */
	public static ResultSet classSchedule(String classNO){
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM class_schedule  "
				+"WHERE ClassNO = '"+classNO +"' "
				+"ORDER BY WeekNum,Section ASC";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 提交管理员填写的教学信息
	 * @param tp
	 */
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
	
	/**
	 * 根据教学信息得到班级课表
	 * @param classNO
	 * @return
	 */
	public static String[][] queryTimeTable(String classNO){
		String[][] timeTable = new String[5][7];
		ResultSet rs = TeachProgramDao.classSchedule(classNO);
		int week,section;
		try {
			while (rs != null && rs.next() ) {	
				week = rs.getInt("WeekNum");
				section = rs.getInt("Section");
				String value = rs.getString("CourseName")+"<br>"
									+rs.getString("TeacherName")+"<br>"
									+rs.getString("RoomNO")+"<br>"
									+rs.getString("StartWeek")+"-"+rs.getString("endWeek")+"周<br>";
				timeTable[section][week] = value;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return timeTable;
	}

}

package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.bean.ElectiveClass;
import com.hbut.util.ConnectSQL;

public class ElectiveClassDao {
	
	/**
	 * 向选修课表插入一条记录（选修课ec）
	 * @param ec
	 */
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
	
	/**
	 * 查询除某学生已选课程外的其他选修课
	 * @param stuNO
	 * @return
	 */
	public static ResultSet queryEelectiveClass(String stuNO) {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM elective_class WHERE SelectClassNO NOT IN( "
					+ "SELECT SelectClassNO FROM hbut_student WHERE StudentNO = '"
					+ stuNO+"')";
//		System.out.println("queryEelectiveClass:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查询某教师的选修课记录
	 * @param teaNO
	 * @return
	 */
	public static ResultSet teacherElectiveClass(String teaNO){
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM teacher_electiveclass WHERE TeacherNO = '"
					+ teaNO+"'";
//		System.out.println("teacherElectiveClass:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查询所有选修课
	 * @return
	 */
	public static ResultSet allEleClass() {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM elective_class  ";
//		System.out.println("allEleClass:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 查询某学生的已选课程
	 * @param stuNO
	 * @return
	 */
	public static ResultSet selectedClass(String stuNO) {
		ResultSet rs = null;
		Connection conn = ConnectSQL.getConnection();
		String sql = "SELECT * FROM elective_class WHERE SelectClassNO IN("
						+ "SELECT SelectClassNO FROM hbut_student WHERE StudentNO = '"
						+ stuNO +"')";
//		System.out.println("selectedClass:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}

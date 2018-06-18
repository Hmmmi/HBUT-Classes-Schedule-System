package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbut.util.ConnectSQL;

public class StudentDao {
	
	/**
	 * 根据学生号获取学生所在班级
	 * @param stuNO
	 * @return
	 */
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
	
	/**
	 * 保存学生选课信息
	 * @param selClassNO
	 * @param stuNO
	 */
	public static void saveSelectClass(String selClassNO,String stuNO){
		Connection conn = ConnectSQL.getConnection();
		String sql = "UPDATE hbut_student SET SelectClassNO = '"
						+ selClassNO+"'  WHERE StudentNO = '"+stuNO+"'";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			int rs = pstate.executeUpdate();
			if (rs==1) {
				System.out.println("选修课添加成功");
			}
		} catch (SQLException e1) {
			System.out.println("选修课添加失败");
			e1.printStackTrace();
		}
	}
	
	/**
	 * 删除学生选课信息
	 * @param stuNO
	 */
	public static void delSelectClass(String stuNO){
		Connection conn = ConnectSQL.getConnection();
		String sql = "UPDATE hbut_student SET SelectClassNO = NULL"
						+ " WHERE StudentNO = '"+stuNO+"'";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			int rs = pstate.executeUpdate();
			if (rs==1) {
				System.out.println("选修课删除成功");
			}
		} catch (SQLException e1) {
			System.out.println("选修课删除失败");
			e1.printStackTrace();
		}
	}

}

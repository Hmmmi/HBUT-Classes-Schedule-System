package com.hbut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hbut.bean.Course;
import com.hbut.util.ConnectSQL;

public class CourseDao {
	
	public static void insertCourse(Course c){
		Connection conn = ConnectSQL.getConnection();
		String sql = "INSERT INTO hbut_course ("
				+ "CourseNO, CourseName, CourseType, CourseCredit, CourseTime) "
				+ " VALUES ("
				+ "'"+c.getCourseNO()+"', '"+c.getCourseName()
				+ "', '"+c.getCourseType()+"', '"+c.getCredie()
				+ "', '"+c.getCourseTime()+"' )";
		System.out.println("CourseDao:"+sql);
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			// System.out.println(sql);
			int rs = pstate.executeUpdate();
			if (rs==1) {
				System.out.println("事件添加成功");
			}
		} catch (SQLException e1) {
			System.out.println("事件添加失败");
			e1.printStackTrace();
		}
	}

}

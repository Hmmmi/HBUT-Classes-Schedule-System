package com.hbut.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.hbut.dao.StudentDao;
import com.hbut.dao.TeachProgramDao;

public class StudentAction extends ActionSupport{
	
	private static final long serialVersionUID = -3432242185210308329L;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map session = ActionContext.getContext().getSession();
	private String[][] timeTable = new String[5][7];
	
	public StudentAction(){
		request = ServletActionContext.getRequest();
		}
	
/**
 * 课表查看
 * @return
 */
	public String showSchedule() {
		String userNO = request.getParameter("UserNO").toString();
		String classNO = "" ;
		String strClass = "";
		try {
			classNO = StudentDao.getClassNO(userNO);
			strClass = StudentDao.getClassName(userNO);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("StuShowSchdeule:"+classNO);
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
		request.setAttribute("stutimeTable", timeTable);
		request.setAttribute("strClass", strClass);
		return SUCCESS;
	}
	
	public String searchEmptyRoom() {
		return SUCCESS;
	}
	
	public String selectClass() {
		return SUCCESS;
	}
	
	
}

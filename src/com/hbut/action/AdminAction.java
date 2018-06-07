package com.hbut.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	
	private static final long serialVersionUID = -3432242185210308329L;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map session = ActionContext.getContext().getSession();
	
	public AdminAction(){
		request = ServletActionContext.getRequest();
		}
	
/**
 * 排课
 * @return
 */
	public String scheduleCoursePage() {
		String userNO = request.getParameter("UserNO").toString();
		System.out.println(userNO);
//		String strClass = "";
//		try {
//			strClass = StudentDao.getClassName(userNO);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		ResultSet rs = TeachProgramDao.stuSchedule(userNO);
//		int week,section;
//		try {
//			while (rs != null && rs.next() ) {	
//				week = rs.getInt("WeekNum");
//				section = rs.getInt("Section");
//				String value = rs.getString("CourseName")+"<br>"
//									+rs.getString("TeacherName")+"<br>"
//									+rs.getString("RoomNO")+"<br>"
//									+rs.getString("StartWeek")+"-"+rs.getString("endWeek")+"周<br>";
//				timeTable[section][week] = value;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		request.setAttribute("stutimeTable", timeTable);
//		request.setAttribute("strClass", strClass);
		return SUCCESS;
	}
	
	public String searchEmptyRoom() {
		return SUCCESS;
	}
	
	
}

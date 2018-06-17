package com.hbut.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.hbut.bean.Course;
import com.hbut.bean.ElectiveClass;
import com.hbut.dao.CourseDao;
import com.hbut.dao.ElectiveClassDao;
import com.hbut.dao.TeachProgramDao;

public class TeacherAction extends ActionSupport{
	
	private static final long serialVersionUID = -3432242185210308329L;
	private static String userNO;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	@SuppressWarnings("rawtypes")
	private Map session = ActionContext.getContext().getSession();
	private static String[][] timeTable = new String[5][7];
	
	public TeacherAction(){
		request = ServletActionContext.getRequest();
		}
	
/**
 * 课表查看
 * @return
 */
	public String showSchedule() {
		iniTable();
		userNO = request.getParameter("UserNO").toString();
		ResultSet rs = TeachProgramDao.teacherSchedule(userNO);
		ResultSet electiveClassRs = ElectiveClassDao.teacherElectiveClass(userNO);
		int week,section;
		try {
			while (rs != null && rs.next() ) {	
				week = rs.getInt("WeekNum");
				section = rs.getInt("Section");
				String value = rs.getString("CourseName")+"<br>"
									+rs.getString("Grade")+rs.getString("Major")+"-"+rs.getString("Ind")+"<br>"
									+rs.getString("RoomNO")+"<br>"
									+rs.getString("StartWeek")+"-"+rs.getString("endWeek")+"周<br>";
				timeTable[section][week] = value;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/********************选修课记录***********************/
		int eleWeek,eleSection;
		try {
			while (electiveClassRs != null && electiveClassRs.next() ) {	
				eleWeek = electiveClassRs.getInt("WeekNum");
				eleSection = electiveClassRs.getInt("Section");
				String value = electiveClassRs.getString("CourseName")+"<br>"
									+electiveClassRs.getString("RoomNO")+"<br>"
									+electiveClassRs.getString("StartWeek")+"-"+electiveClassRs.getString("endWeek")+"周<br>";
				timeTable[eleWeek][eleSection] = value;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("timeTable", timeTable);
		return SUCCESS;
	}
	
	private void iniTable() {
		for(int i = 0 ; i < 5 ; i ++ ){
			for(int j = 0 ; j < 7 ; j++){
				timeTable[i][j] = "";
			}
		}
	}

	public String searchEmptyRoom() {
		return SUCCESS;
	}
	
	public String addCoursePage() {
		return SUCCESS;
	}
	
	public String addCourse(){
		String userType = session.get("UserType").toString();
//		String userNO = request.getParameter("UserNO").toString();
		System.out.println("addCourse UserNO:"+userNO);
		request.setAttribute("userType",userType);
		String courseName = request.getParameter("CourseName");
		int courseType = Integer.valueOf( request.getParameter("CourseType") );
		float courseCredit = Float.valueOf( request.getParameter("Credit") );
		int courseTime = Integer.valueOf( request.getParameter("CourseTime") );
		
		Course c = new Course(courseName,courseType,courseCredit,courseTime);
		CourseDao.insertCourse(c);
		//如果是公选课
		if(courseType == 3){
			String roomNO = request.getParameter("roomNO");
			int peopleNum = Integer.valueOf( request.getParameter("CoursePeople") );
			int startWeek = Integer.valueOf( request.getParameter("startWeek") );
			int endWeek = Integer.valueOf( request.getParameter("endWeek") );
			int section = Integer.valueOf( request.getParameter("CourseSection") );
			int weekNum = Integer.valueOf( request.getParameter("CourseWeek") );
			ElectiveClass ec = new ElectiveClass(c.getCourseNO(),userNO,roomNO,peopleNum,startWeek,endWeek,section,weekNum);
			System.out.println(ec.toString());
			ElectiveClassDao.saveElectiveClass(ec);
		}
//		System.out.println(courseNo+" "+courseName+" "+courseType+" "+courseCredit+" "+courseTime);
		request.setAttribute("timeTable", timeTable);
		return "RESULT";
	}
	
	
}

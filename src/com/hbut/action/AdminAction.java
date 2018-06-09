package com.hbut.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hbut.bean.TeachProgramBean;
import com.hbut.dao.TeachProgramDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	
	private static final long serialVersionUID = -3432242185210308329L;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map session = ActionContext.getContext().getSession();
	private static String scheduleClassNO;
	
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
		return SUCCESS;
	}
	
	public String searchEmptyRoom() {
		return SUCCESS;
	}
	
	public String putupdateSchedule(){
//		System.out.println("Schedule Class Num:");
		scheduleClassNO = request.getParameter("scheduleClassNO");
		request.setAttribute("action", "updateSchedule");
		return SUCCESS;
	}
	
	public String updateSchedule(){
//		List<TeachProgramBean> tpList = new ArrayList<TeachProgramBean>();
		String courseNO,roomNO,classNO,teacherNO;
		int startWeek,endWeek,section,weekNum;
		
		for(int i = 0 ; i < 5 ; i++ ){
				for(int j = 0 ; j< 7 ; j++){
					
					courseNO = request.getParameter("courseNO"+i+j);
					roomNO = request.getParameter("roomNO"+i+j);
					classNO = scheduleClassNO;
					teacherNO = request.getParameter("teacherNO"+i+j);
					if( ! courseNO.equals("WU")  ){
						startWeek = Integer.valueOf(  request.getParameter("startWeek"+i+j)  );
						endWeek = Integer.valueOf(  request.getParameter("endWeek"+i+j)  );
						section = Integer.valueOf( i  );
						weekNum = Integer.valueOf( j );
					
						TeachProgramBean tp = new TeachProgramBean(courseNO,roomNO,classNO,teacherNO,startWeek,endWeek,section,weekNum);
						System.out.println("updateSchedule:"+tp);
						TeachProgramDao.saveTeacheProgram(tp);
					}
				}
//			System.out.println(request.getParameter("courseNO"+i+"0"));
		}
		return SUCCESS;
	}
	
}

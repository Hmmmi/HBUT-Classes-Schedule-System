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
		return SUCCESS;
	}
	
	public String searchEmptyRoom() {
		return SUCCESS;
	}
	
	public String updateSchedule(){
		System.out.println("Schedule Class Num:");
		System.out.println(request.getParameter("scheduleClassNO"));
		return SUCCESS;
	}
	
}

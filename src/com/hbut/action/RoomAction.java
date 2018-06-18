package com.hbut.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport{
	
	private static final long serialVersionUID = -3432242185210308329L;
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	@SuppressWarnings({ "unused", "rawtypes" })
	private Map session = ActionContext.getContext().getSession();
	
	public RoomAction(){
		request = ServletActionContext.getRequest();
		}
	
	/**
	 * 课表查看
	 * @return
	 */
	public String showResult() {
		int queryWeekNum = Integer.valueOf(request.getParameter("queryWeekNum").toString());
		int queryPeopleNum = Integer.valueOf(request.getParameter("queryPeopleNum").toString());
		int queryDayNum = Integer.valueOf(request.getParameter("queryDayNum").toString());
		int querySectionNum = Integer.valueOf(request.getParameter("querySectionNum").toString());
		request.setAttribute("queryWeekNum", queryWeekNum);
		request.setAttribute("queryPeopleNum", queryPeopleNum);
		request.setAttribute("queryDayNum", queryDayNum);
		request.setAttribute("querySectionNum", querySectionNum);
		return SUCCESS;
	}
	
}

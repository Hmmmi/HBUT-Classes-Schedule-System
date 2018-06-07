package com.hbut.action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.hbut.util.ConnectSQL;

@SuppressWarnings("serial")
public class Login extends ActionSupport implements SessionAware {

	private String userName; 		// 用户名
	private String userNO;
	private int userType;
	@SuppressWarnings("rawtypes")
	private Map session; 			// session
	private Connection conn;
	private PreparedStatement pstmt;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public void setSession(@SuppressWarnings("rawtypes") Map session) {
		this.session = session;
	}

	private HttpServletResponse response = ServletActionContext.getResponse();

	public Login() {
		conn = ConnectSQL.getConnection();
	}

	/*****************************************************************
	 * 方法名 : execute  输入参数： 输出参数：null/LoginFail 功能描述:
	 * 连接数据库验证用户名ID和密码，判断权限返回不同的action。登陆成功返回上一级页面，函数返回null；登陆失败返回“LoginFail”。
	 * 返回LoginFail重新加载登录界面 修改历史：
	 ******************************************************************/
	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		response.setContentType("text/html;charset=utf-8");
//		System.out.println(userType + "  " +userNO + "  " + userName);
		try {
			// 加载数据库
			conn = ConnectSQL.getConnection();
			Statement sta = conn.createStatement();
			
/****************************学生登陆*****************************/
			if(userType == 1){
				String stusql = "SELECT StudentNO,StudentName from hbut_student WHERE StudentName='"
						+ userName + "' ";
				ResultSet stuRs = sta.executeQuery(stusql);
				
				// 验证用户名，通过则从数据库取出用户数据
				if ( stuRs != null && stuRs.next() ) {
					if(!userNO.equals(stuRs.getString("StudentNO"))){
						PrintWriter pw = response.getWriter();
						pw.write("<script language='javascript'>alert('密码输入有误'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
						return null;
					}
					userNO = stuRs.getString("StudentNO");
				} else {
					PrintWriter pw = response.getWriter();
					pw.write("<script language='javascript'>alert('用户名不存在'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
					return null;
				}
				this.session.put("userNO", userNO);
				this.session.put("userName", userName);
				this.session.put("UserType", userType);
				return "stuLogin";
			}
/****************************教师登陆*****************************/
			else if(userType == 2){
				String teasql = "SELECT TeacherNO,TeacherName from hbut_teacher WHERE TeacherName='"
						+ userName + "' ";
				ResultSet teaRs = sta.executeQuery(teasql);
				
				// 验证用户名，通过则从数据库取出用户数据
				if ( teaRs != null && teaRs.next() ) {
					if(!userNO.equals(teaRs.getString("TeacherNO"))){
						PrintWriter pw = response.getWriter();
						pw.write("<script language='javascript'>alert('密码输入有误'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
						return null;
					}
					userNO = teaRs.getString("TeacherNO");
				} else {
					PrintWriter pw = response.getWriter();
					pw.write("<script language='javascript'>alert('用户名不存在'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
					return null;
				}
				this.session.put("userNO", userNO);
				this.session.put("userName", userName);
				this.session.put("UserType", userType);
				return "teaLogin";
			}
/****************************管理员登陆*****************************/
			else{
				String teasql = "SELECT AdminNO,Password from hbut_admin WHERE AdminNO='"
						+ userName + "' ";
				ResultSet teaRs = sta.executeQuery(teasql);
				
				// 验证用户名，通过则从数据库取出用户数据
				if ( teaRs != null && teaRs.next() ) {
					if(!userNO.equals(teaRs.getString("Password"))){
						PrintWriter pw = response.getWriter();
						pw.write("<script language='javascript'>alert('密码输入有误'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
						return null;
					}
					userNO = teaRs.getString("Password");
				} else {
					PrintWriter pw = response.getWriter();
					pw.write("<script language='javascript'>alert('用户名不存在'); location.href='/HbutClassSys/pageAreas/login.jsp'</script>");
					return null;
				}
				this.session.put("userNO", userNO);
				this.session.put("userName", userName);
				this.session.put("UserType", userType);
				return "adminLogin";
			}
		} catch (Exception e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		// 验证失败，返回登录界面重新登录
		return INPUT;
	}

	// 退出登录的方法
	public String logout() throws Exception {
		@SuppressWarnings("rawtypes")
		Map session1 = ActionContext.getContext().getSession();
		session1.clear();
		// System.out.println("LogoutSessionUserName="+session.get("UserName"));
		return SUCCESS;
	}

	// 退出整个系统
	public String systemQuit() {
		@SuppressWarnings("rawtypes")
		Map session1 = ActionContext.getContext().getSession();
		session1.clear();
		ConnectSQL.closeconn();
		return null;
	}
}
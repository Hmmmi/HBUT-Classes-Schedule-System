package com.hbut.bean;

import java.util.UUID;

public class TeachProgramBean {
	
	private UUID programID;
	private String courseNO;
	private String roomNO;
	private String classNO;
	private String teacherNO;
	private int startWeek;
	private int endWeek;
	private int section;
	private int weekNum;
	
	public TeachProgramBean(String courseNO,String roomNO,String classNO,String teacherNO,
			 int startWeek,int endWeek,int section,int weekNum) {
		this.programID = UUID.randomUUID();
		this.courseNO = courseNO;
		this.roomNO = roomNO;
		this.classNO = classNO;
		this.teacherNO = teacherNO;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.section = section;
		this.weekNum = weekNum;
	}
	
	public UUID getProgramID() {
		return programID;
	}
	public String getCoureseNO() {
		return courseNO;
	}
	public void setCourseNO(String courseNO) {
		this.courseNO = courseNO;
	}
	public String getRoomNO() {
		return roomNO;
	}
	public void setRoomNO(String roomNO) {
		this.roomNO = roomNO;
	}
	public String getClassNO() {
		return classNO;
	}
	public void setClassNO(String classNO) {
		this.classNO = classNO;
	}
	public String getTeacherNO() {
		return teacherNO;
	}
	public void setTeacherNO(String teacherNO) {
		this.teacherNO = teacherNO;
	}
	public int getStartWeek() {
		return startWeek;
	}
	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}
	public int getEndWeek() {
		return endWeek;
	}
	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(int weekNum) {
		this.weekNum = weekNum;
	}
	
	@Override
	public String toString() {
		String res = this.getProgramID() +","+ this.getCoureseNO() +","+ this.getRoomNO() +","+
							this.getTeacherNO() +","+ this.getStartWeek() +","+ this.getEndWeek() +","+
							this.getSection() +","+ this.getWeekNum() ;
		return "{"+res+"}";
	}
	
}

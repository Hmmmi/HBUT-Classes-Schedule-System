package com.hbut.bean;

import java.util.UUID;

public class ElectiveClass {
	
	private UUID selectClassNO;
	private UUID courseNO;
	private String teacherNO;
	private String roomNO;
	private int peopleNum;
	private int startWeek;
	private int endWeek;
	private int section;
	private int weekNum;
	
	public ElectiveClass(UUID courseNO,String teacherNO,String RoomNO,int peopleNum,int startWeek,int endWeek,int section,int weekNum) {
		this.selectClassNO = UUID.randomUUID();
		this.courseNO = courseNO;
		this.teacherNO = teacherNO;
		this.roomNO = RoomNO;
		this.peopleNum = peopleNum;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.section = section;
		this.weekNum = weekNum;
		
	}
	
	public UUID getSelectClassNO() {
		return selectClassNO;
	}
	public void setSelectClassNO(UUID selectClassNO) {
		this.selectClassNO = selectClassNO;
	}
	public UUID getCourseNO() {
		return courseNO;
	}
	public void setCourseNO(UUID courseNO) {
		this.courseNO = courseNO;
	}
	public String getTeacherNO() {
		return teacherNO;
	}
	public void setTeacherNO(String teacherNO) {
		this.teacherNO = teacherNO;
	}
	public String getRoomNO() {
		return roomNO;
	}
	public void setRoomNO(String roomNO) {
		this.roomNO = roomNO;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
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
		String res = "SelectClass Info:";
		res += "["+this.getSelectClassNO()+","+this.getTeacherNO()+","+this.getRoomNO()+","
							+this.getPeopleNum()+","+this.getStartWeek()+","+this.getEndWeek()+","
							+this.getSection()+","+this.getWeekNum()+"]";
		return res;
	}

}

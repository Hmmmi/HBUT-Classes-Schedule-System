package com.hbut.bean;

import java.util.UUID;

public class Course {
	
	private UUID courseNO;
	private String courseName;
	private int courseType;
	private float credie;
	private int courseTime;
	
	public UUID getCourseNO() {
		return courseNO;
	}
	public void setCourseNO(UUID courseNO) {
		this.courseNO = courseNO;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public float getCredie() {
		return credie;
	}
	public void setCredie(float credie) {
		this.credie = credie;
	}
	public int getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}
	
	public Course(String name,int type,float credit,int time) {
		this.courseNO = UUID.randomUUID();
		this.courseName = name;
		this.courseType = type;
		this.credie = credit;
		this.courseTime = time;
	}

}

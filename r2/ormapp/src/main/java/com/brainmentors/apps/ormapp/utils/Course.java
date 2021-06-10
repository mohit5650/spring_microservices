package com.brainmentors.apps.ormapp.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	//@Column(name="sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  cid;
	private String name;
	private int duration;
	
	public Course() {
		
	}
	
	public Course(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
//	@OneToOne
//	@MapsId
//	@JoinColumn(name="sid")
	//@ManyToOne
	private ITStudent student;
	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}

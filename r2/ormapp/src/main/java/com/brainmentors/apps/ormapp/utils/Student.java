package com.brainmentors.apps.ormapp.utils;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student_mst")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	//@OneToOne(cascade = CascadeType.ALL, mappedBy ="student" )
	@OneToOne
	@JoinTable(name="student_course_mapping",joinColumns = {
			@JoinColumn(name="sid",referencedColumnName = "id"),
			
	},inverseJoinColumns = {
			@JoinColumn(name="cid",referencedColumnName = "cid")
	})
	//@PrimaryKeyJoinColumn
	//@JoinColumn(name="courseid", referencedColumnName = "cid")
	private Course course ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

}

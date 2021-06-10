package com.brainmentors.apps.isademo.singletabledemo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Student extends Person {
private int rollno;
private String course;
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(int rollno, String course, String name, String address) {
	super(name, address);
	this.rollno = rollno;
	this.course = course;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}

}

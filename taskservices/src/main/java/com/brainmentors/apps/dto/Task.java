package com.brainmentors.apps.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Task {
	@NotNull(message = "Id Cannot be Null")
	private int id;
	@NotNull(message = "Name Cannot be Null")
	@Size(min = 3,max = 25 , message = "Name Must be in B/W 3 to 25 Chars")
	private String name;
	@NotNull(message = "Desc Cannot be Null")
	private String desc;
	@NotNull(message = "Duration Cannot be Null")
	@Min(value = 1,message = "Duration cannot be less than 1 Hour")
	@Max(value = 24, message = "Duration cannot be greater than 24 Hour")
	private int duration;
	
	public Task() {}
	
	public Task(int id, String name, String desc, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
	}
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", desc=" + desc + ", duration=" + duration + "]";
	}
	

}

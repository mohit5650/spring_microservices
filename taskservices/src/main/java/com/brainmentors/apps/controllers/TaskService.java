package com.brainmentors.apps.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.apps.dto.Task;
import com.brainmentors.apps.utils.exceptions.TaskNotFoundException;

@RestController
public class TaskService {
	@PostMapping(path="/addtask",consumes = {
			
			MediaType.APPLICATION_JSON_VALUE
	},produces = {
			
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) {
			//return task.toString();
		//String myName = null;
		//int len  = myName.length();
		if(20>2) {
		throw new TaskNotFoundException("This Task is Not Exist in the DB....");
		}
		return new ResponseEntity<Task>(task,HttpStatus.OK);
				
	}
	
	@GetMapping(path="/task/{taskid}")
	public String getTask(@PathVariable(value = "taskid") String id) {
		return "Task Id "+id;
	}
	
	@GetMapping(path="/task2")
	public String getTask2(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "name",defaultValue = "A Task", required = false) String name) {
		return "Task Id "+id +" Name "+name;
	}
	
	
	
	

}

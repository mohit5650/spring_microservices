package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Expense;

@Repository
public class ExpenseDAO {
	List<Expense> expenses  = new ArrayList<>();
	public List<Expense> getAllExpenses(){
		//expenses = Arrays.asList(new Expense(1001, "Abc", 10, "ABCD"),new Expense(1002, "Xyz", 10, "Xyzed"));
		return expenses;

	
	}
	
	public boolean add(Expense expense) {
		return expenses.add(expense);
	}
	
	public Expense findById(int id) {
		int index = expenses.indexOf(new Expense(id));
		System.out.println("Index is "+index);
		return index==-1?null:expenses.get(index);
//		var expense = new Expense();
//		expense.setId(id);
//		int index = expenses.indexOf(expense);
//		if(index!=-1) {
//			return expenses.get(index);
//		}
//		return null;
	}
}

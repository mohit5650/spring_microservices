<%@page import="com.brainmentors.utils.DateParser"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense ToDo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<%
String name = request.getParameter("name");
String date = request.getParameter("date");
Date date1 = null;
//System.out.println("NAME AND DATE "+name +" "+date);
if(name!=null && date!=null){

	
int cost = Integer.parseInt(request.getParameter("cost"));

date1 = DateParser.parse(date);
String color = request.getParameter("color");
String url = request.getParameter("url");
String remarks = request.getParameter("remarks");
}
%>
Name <%=name %> Date <%=date1 %>
        <div class='container'>
        <form method='post' action="add.jsp">
             <h2 class='alert-info text-center'>Expense ToDo</h2>
             <div class='form-group'>
                 <label for="">Name</label>
                <input name="name" class='form-control' type="text" placeholder="Type Expense Name">
            </div>
            <div class='form-group'>
                <label for="">Cost</label>
               <input name="cost" class='form-range' type="range" min="1" max="1000">
            <output>0</output>
            </div>
            <div class='form-group'>
                <label for="">Date</label>
               <input name="date" class='form-control' type="date" >

            </div>
            <div class='form-group'>
                <label for="">Color</label>
               <input name="color" class='form-control' type="color" >

            </div>
            <div class='form-group'>
                <label for="">URL</label>
               <input name="url" class='form-control' placeholder="Type URL Here" type="text" >

            </div>
            <div class='form-group'>
                <label for="">Remarks</label>
               <textarea name="remarks" placeholder="Type Remarks Here" class='form-control'  cols="30" rows="5"></textarea>

            </div>
            <div class='form-group'>
               <button class='btn btn-primary'>Add</button>
               <button class='btn btn-secondary'>Clear All</button>
            </div>
            </form>
        </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lohith.mypaymentwebapp.entity.UserEntity" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<UserEntity> userList = (List<UserEntity>)request.getAttribute("user");
if (userList != null && !userList.isEmpty()) {
    UserEntity user = userList.get(0); 
%>
<h1>Name: <%= user.getFirstName() %></h1> 
<h1>First Name: <%= user.getLastName() %></h1> 
<h1>Last Name: <%= user.getUserName() %></h1> 
<h1>Email: <%= user.getEmail() %></h1> 
<h1>Adress: <%= user.getAddress() %></h1> 

<% 
} else {
%>
<p>No user found with that phone number.</p>
<% 
}
%>
</body>
</html>
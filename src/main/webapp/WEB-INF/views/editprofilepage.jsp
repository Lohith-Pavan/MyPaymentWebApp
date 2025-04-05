<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lohith.mypaymentwebapp.model.UserRegistrationModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f9f9f9;
        }
        .form-container {
            background: white;
            max-width: 500px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type=text], input[type=email], input[type=tel], input[type=password] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            background-color: #28a745;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type=submit]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<% UserRegistrationModel user = (UserRegistrationModel)request.getAttribute("userEditProfile");
if(user!= null){%>
<div class="form-container">
    <h2>Edit Profile</h2>
    <form action="/updateUser" method="POST">
        <label>First Name</label>
        <input type="text" name="firstName" value="<%=user.getFirstName()%>" required>

        <label>Last Name</label>
        <input type="text" name="lastName" value="<%=user.getLastName()%>" required>

        <label>Phone Number</label>
        <input type="tel" name="phoneNumber" value="<%=user.getPhoneNumber()%>" required>

        <label>Email</label>
        <input type="email" name="email" value="<%=user.getEmail()%>" required>

        <label>Address</label>
        <input type="text" name="address" value="<%=user.getAddress()%>" required>

        <label>User Name</label>
        <input type="text" name="userName" value="<%=user.getUserName()%>" required>

        <label>Password</label>
        <input type="password" name="password" value="<%=user.getPassword()%>" required>

        <input type="submit" value="Update">
    </form>
    <%} %>
</div>

</body>
</html>
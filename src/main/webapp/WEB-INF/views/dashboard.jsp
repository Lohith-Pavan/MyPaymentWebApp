<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lohith.mypaymentwebapp.model.UserDashboardModel" %>
<%@ page import="com.lohith.mypaymentwebapp.model.UserViewBankModel" %>
<%@ page import="com.lohith.mypaymentwebapp.model.UserProfileModel" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment App Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f2f6fc;
            font-family: 'Segoe UI', sans-serif;
        }
        .app-header {
            background: linear-gradient(90deg, #0077ff, #00c6ff);
            color: white;
            padding: 20px 30px;
            border-radius: 12px;
        }
        .logout-btn {
            background-color: #ff4d4d;
            color: white;
            border: none;
        }
        .section {
            background-color: #ffffff;
            border-radius: 16px;
            padding: 20px;
            margin-top: 25px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.06);
        }
        .section h4 {
            font-weight: bold;
            color: #0077ff;
        }
        .card {
            border: none;
            border-radius: 16px;
            background-color: #f0f8ff;
        }
        .btn-primary {
            background: linear-gradient(45deg, #00c6ff, #0077ff);
            border: none;
            font-weight: bold;
        }
        .btn-outline-primary {
            border-color: #0077ff;
            color: #0077ff;
        }
        .btn-outline-primary:hover {
            background-color: #0077ff;
            color: white;
        }
    </style>
</head>
<body>

<div class="container-fluid p-4">
    <!-- Header -->
    <div class="row app-header align-items-center mb-4">
        <div class="col-md-10 text-center">
            <h2 class="m-0">💸 Payment App Dashboard</h2>
        </div>
        <div class="col-md-2 text-end">
            <form action="/logout">
                <button class="btn logout-btn">Logout</button>
            </form>
        </div>
    </div>

    <!-- Profile Section -->
		<div class="row section">
			<div class="col-12 d-flex justify-content-between align-items-center">
				<h4>👤 Profile Information</h4>
				<a href="/editprofilepage" class="btn btn-sm btn-outline-primary">✏️
					Edit</a>
			</div>
			<div class="col-12 mt-2">
			<% 
        UserDashboardModel userDashboardModel = (UserDashboardModel)request.getAttribute("userDashboardModel");
		if(userDashboardModel!=null){
			UserProfileModel userProfile = userDashboardModel.getUserProfileModel();
			List<UserViewBankModel> banksList = userDashboardModel.getUserBanksListModel();
        %>
				<p>
					<strong>First Name:</strong>
					<%=(userProfile!=null?userProfile.getFirstName():"N/A")%></p>
				<p>
					<strong>Last Name:</strong>
					<%=(userProfile!=null?userProfile.getLastName():"N/A")%></p>
				<p>
					<strong>Phone Number:</strong>
					<%=(userProfile!=null?userProfile.getPhoneNumber():"N/A")%></p>
				<p>
					<strong>Email:</strong>
					<%=(userProfile!=null?userProfile.getEmail():"N/A")%></p>
				<p>
					<strong>Address:</strong>
					<%=(userProfile!=null?userProfile.getAddress():"N/A")%></p>
			</div>
		</div>

		<!-- Primary Bank Account -->
    <div class="row section">
        <div class="col-12">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h4>🏦 Primary Bank Account</h4>
                <a href="/sendmoney" class="btn btn-primary">Send Money</a>
            </div>
            <div class="row">
                <div class="col-md-6">
                <%if(banksList!=null && banksList.size()>0){ 
                      UserViewBankModel selectedBank = banksList.get(0);
                %>
                    <p><strong>Bank Name:</strong> <%=(selectedBank!=null?selectedBank.getBankName():"N/A")%></p>
                    <p><strong>Account No:</strong><%=(selectedBank!=null?selectedBank.getAccountNumber():"N/A")%></p>
                    <p><strong>Balance:</strong> ₹<%=(selectedBank!=null?selectedBank.getCurrentBalance():"N/A")%></p>
                </div>
                <div class="col-md-6">
                    <p><strong>IFSC:</strong> <%=(selectedBank!=null?selectedBank.getIfscCode():"N/A")%></p>
                    <p><strong>Branch:</strong> <%=(selectedBank!=null?selectedBank.getBankBranch():"N/A")%></p>
                </div>
                <% }} %>
            </div>
        </div>
    </div>

    <!-- Linked Bank Accounts -->
    <div class="row section">
        <h4>🏦 Linked Bank Accounts</h4>
        <div class="col-md-3 col-sm-6 mb-3">
            <div class="card p-3 text-center">
                <p><strong>SBI</strong></p>
                <p>Acct: 4567</p>
                <p>Balance: ₹5,000</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 mb-3">
            <div class="card p-3 text-center">
                <p><strong>HDFC</strong></p>
                <p>Acct: 6789</p>
                <p>Balance: ₹10,000</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 mb-3">
            <div class="card p-3 text-center">
                <p><strong>ICICI</strong></p>
                <p>Acct: 9876</p>
                <p>Balance: ₹15,000</p>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 mb-3 d-flex align-items-center justify-content-center">
            <a href="/addbankaccount" class="btn btn-success w-100">+ Add Account</a>
        </div>
    </div>

    <!-- Recent Transactions -->
    <div class="row section">
        <div class="col-12 d-flex justify-content-between align-items-center">
            <h4>🧾 Recent Transactions</h4>
            <a href="/detailedstatementpage" class="btn btn-outline-primary">Detailed Statement</a>
        </div>
        <div class="col-12 mt-3">
            <ul class="list-group">
                <li class="list-group-item">Paid ₹500 to Amazon - 01 Apr</li>
                <li class="list-group-item">Received ₹1200 from Rahul - 30 Mar</li>
                <li class="list-group-item">Paid ₹300 to Flipkart - 28 Mar</li>
            </ul>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

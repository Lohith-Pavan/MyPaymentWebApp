<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Bank Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #f2f6fc, #e6f0ff);
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .form-box {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            border: 2px solid #007bff;
        }
        .form-heading {
            text-align: center;
            color: #d40000;
            font-weight: bold;
            font-size: 26px;
            margin-bottom: 25px;
            border: 2px solid #d40000;
            padding: 10px;
            border-radius: 10px;
        }
        label {
            color: #0033cc;
            font-weight: 500;
        }
        .btn-custom {
            background: linear-gradient(45deg, #007bff, #00c6ff);
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            padding: 10px 20px;
        }
        .btn-custom:hover {
            background: linear-gradient(45deg, #0056b3, #0096ff);
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-heading">Add Bank Account</div>
    <div class="form-box">
        <form action="/addbankaccount" method="post">
            <div class="mb-3">
                <label for="bankName" class="form-label">Bank Name:</label>
                <input type="text" class="form-control" id="bankName" name="userAddBankModel.bankName" required>
            </div>
            <div class="mb-3">
                <label for="accountNumber" class="form-label">Account Number:</label>
                <input type="text" class="form-control" id="accountNumber" name="userAddBankModel.accountNumber" required>
            </div>
            <div class="mb-3">
                <label for="ifscCode" class="form-label">IFSC Code:</label>
                <input type="text" class="form-control" id="ifscCode" name="userAddBankModel.ifscCode" required>
            </div>
            <div class="mb-3">
                <label for="balance" class="form-label">Current Balance:</label>
                <input type="number" class="form-control" id="balance" name="userAddBankModel.balance" required>
            </div>
            <div class="mb-3">
                <label for="pin" class="form-label">PIN:</label>
                <input type="password" class="form-control" id="pin" name="userAddBankModel.pin" required>
            </div>
            <div class="mb-3">
                <label for="bankBranch" class="form-label">Branch:</label>
                <input type="text" class="form-control" id="bankBranch" name="userAddBankModel.bankBranch" required>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-custom">Add Account</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>

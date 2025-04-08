<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Send Money</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #f0f5ff, #e0f7fa);
            font-family: 'Segoe UI', sans-serif;
        }

        .container {
            max-width: 600px;
            margin-top: 50px;
        }

        .form-heading {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            color: red;
            border: 2px solid red;
            padding: 10px;
            margin-bottom: 30px;
            border-radius: 10px;
        }

        .form-box {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            border: 2px solid #0047ab;
        }

        label {
            color: #0047ab;
            font-weight: 600;
        }

        .form-check-label {
            font-weight: 500;
            color: #ff6600;
        }

        .form-control:focus {
            border-color: #0066cc;
            box-shadow: 0 0 0 0.2rem rgba(0,123,255,.25);
        }

        .btn-send {
            background-color: white;
            color: #0047ab;
            font-weight: bold;
            border: 2px solid red;
            border-radius: 25px;
            padding: 8px 25px;
        }

        .btn-send:hover {
            background-color: red;
            color: white;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-heading">SEND MONEY</div>
    <div class="form-box">
        <form action="sendMoney" method="post">
            <div class="mb-3">
                <label for="amount">Amount to Send:</label>
                <input type="number" class="form-control" id="amount" name="amount" required>
            </div>

            <div class="mb-3">
                <label for="/sendmoney">From:</label>
                <select class="form-control" id="fromAccount" name="fromAccount" required>
                    <option value="">Select Account</option>
                    <option value="1234">Bank A - 1234</option>
                    <option value="5678">Bank B - 5678</option>
                    <!-- Dynamically populate this with user bank accounts -->
                </select>
            </div>

            <div class="mb-3">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transferType" id="toAccount" value="account" checked>
                    <label class="form-check-label" for="toAccount">
                        To Account Number
                    </label>
                </div>
                <input type="text" class="form-control mt-2" name="toAccountNumber" placeholder="Enter Account Number">

                <div class="form-check mt-3">
                    <input class="form-check-input" type="radio" name="transferType" id="toWallet" value="wallet">
                    <label class="form-check-label" for="toWallet">
                        To Wallet
                    </label>
                </div>
                <input type="text" class="form-control mt-2" name="toWallet" placeholder="Enter Wallet ID">
            </div>

            <div class="text-center mt-4">
                <button type="submit" class="btn btn-send">SEND</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>

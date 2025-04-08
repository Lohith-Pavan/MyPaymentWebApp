<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Statement Request</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #fef9f4, #e0f7fa);
            font-family: 'Segoe UI', sans-serif;
        }

        .form-heading {
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            color: orange;
            border: 2px solid red;
            padding: 10px;
            border-radius: 10px;
            margin: 30px auto;
            max-width: 600px;
        }

        .form-box {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
            border: 2px solid #0047ab;
            max-width: 700px;
            margin: auto;
        }

        label {
            font-weight: bold;
            color: orange;
        }

        .form-check-label {
            color: orange;
            font-weight: 500;
        }

        .form-check-input:checked {
            background-color: #0047ab;
            border-color: #0047ab;
        }

        .btn-generate {
            background-color: white;
            color: red;
            font-weight: bold;
            border: 2px solid red;
            border-radius: 25px;
            padding: 8px 25px;
        }

        .btn-generate:hover {
            background-color: red;
            color: white;
        }

        @media (max-width: 576px) {
            .form-check {
                display: block;
                margin-bottom: 10px;
            }

            .form-check-inline {
                display: block;
            }
        }
    </style>
</head>
<body>

<div class="form-heading">Statement Request Page</div>

<div class="form-box">
    <form action="/detailedstatementpage" method="post">
        <div class="row mb-3">
            <div class="col-md-6 col-sm-12 mb-2">
                <label for="startDate">Start DATE:</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="col-md-6 col-sm-12">
                <label for="endDate">End DATE:</label>
                <input type="date" class="form-control" id="endDate" name="endDate" required>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-12">
                <div class="d-flex flex-wrap gap-3">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="all" name="txnType" value="ALL">
                        <label class="form-check-label" for="all">ALL</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="credit" name="txnType" value="CREDIT">
                        <label class="form-check-label" for="credit">Credit Txns</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="debit" name="txnType" value="DEBIT">
                        <label class="form-check-label" for="debit">Debit Txns</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="wallet" name="txnType" value="WALLET">
                        <label class="form-check-label" for="wallet">Wallet Txns</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="bank" name="txnType" value="BANK">
                        <label class="form-check-label" for="bank">Bank Txns</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-generate">GENERATE</button>
        </div>
    </form>
</div>

</body>
</html>

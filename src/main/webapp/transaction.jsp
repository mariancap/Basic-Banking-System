<%@ page import="java.util.List" %>
<%@ page import="com.example.DAO.Transaction" %>
<%@ page import="com.example.DAO.UserFunctions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="This project is about creating a simple banking system.">
    <title>Spark Bank | Reon Fernandes</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/customer.css">
</head>

<body>
<header class="header">
    <div class="logo">
        <a href="index.html">
            <img src="assets/images/Bank logo.jpg" alt="bank logo">
        </a>
    </div>
    <div class="hamburger-navbar">
        <div class="line"></div>
        <div class="line"></div>
        <div class="line"></div>
    </div>
    <nav class="navbar">
        <ul class="navlinks">
            <li><a href="index.html" class="navlink active">Home</a></li>
            <li><a href="customer.jsp" class="navlink">View-Customers</a></li>
            <li><a href="transaction.jsp" class="navlink">Transactions</a></li>
            <li><a href="about.html" class="navlink">About-Us</a></li>
            <li><a href="contact.html" class="navlink">Contact</a></li>
        </ul>
    </nav>
</header>
<section>
    <table>
        <caption>Transaction Details</caption>
        <thead>
        <tr>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Amount</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Retrieve list of transactions from session attribute
            List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
            if (transactions != null) {
                for (Transaction transaction : transactions) {
        %>
        <tr>
            <td><%= transaction.getSender() %></td>
            <td><%= transaction.getReceiver() %></td>
            <td><%= transaction.getAmount() %></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</section>

<script src="assets/js/main.js"></script>
</body>
</html>

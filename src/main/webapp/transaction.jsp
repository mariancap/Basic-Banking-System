<%@ page import="com.example.DAO.UserFunctions" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="This project is about creating a simple banking system.">
    <title>Spark Bank | Reon Fernandes</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
<header class="header">
    <div class="logo">
        <a href="index.jsp">
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
            <li><a href="index.jsp" class="navlink active">Home</a></li>
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
        <tr>
            <td>${Sender}</td>
            <td>${Receiver}</td>
            <td>${Amount}</td>
        </tr>
        </tbody>
    </table>
</section>
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12-Apr-24
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
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
<main>
    <section class="hero-section">
        <div class="parent item">
            <span class="sub-heading1">Hello! and Greetings</span>
            <h1>Welcome to Spark Bank</h1>
            <span class="sub-heading2">Simple | Secured | Efficient | Reliable</span>
            <p>Spark Bank is an online banking service that aims to make money transfers easier for its customers.
                Spark Bank's secure features and user-friendly interface enable users to effectively manage their
                accounts from any location.
            </p>

            <a href="about.html">
                <button class="read-more-btn">Read More</button>
            </a>
        </div>
        <div class="hero-image item">
            <img src="assets/images/images.png" alt="A bank image">
        </div>
    </section>
</main>
<script src="assets/js/main.js"></script>
</body>

</html>
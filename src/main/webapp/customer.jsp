<%@ page import="java.util.List" %>
<%@ page import="com.example.DAO.User" %>
<%@ page import="com.example.DAO.UserFunctions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Customers | Spark Bank</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/customer.css">

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
            <li><a href="index.jsp" class="navlink">Home</a></li>
            <li><a href="customer.jsp" class="navlink">View-Customers</a></li>
            <li><a href="transaction.jsp" class="navlink">Transactions</a></li>
            <li><a href="about.html" class="navlink">About-Us</a></li>
            <li><a href="contact.html" class="navlink">Contact</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="customers" id="customers">
        <div class="transfer-money">
            <span>Enter Details</span>
            <form action="analyze" method="post">

                <input class="customer-inputs" type="text" name="sender" id="sender" placeholder="Senders Name"
                       required autocomplete="off">

                <input class="customer-inputs" type="text" name="receiver" id="receiver"
                       placeholder="Receivers Name" required autocomplete="off">

                <input class="customer-inputs" type="number" name="amount" id="amount" placeholder="Amount" required
                       autocomplete="off">

                <div class="impt-buttons">
                    <button type="submit" class="transfer-btn btn">Transfer</button>
                </div>
            </form>
            <%-- If any error during transaction--%>
            <%
                String message = (String) request.getAttribute("message");
                if (message != null && !message.isEmpty()) {
            %>
            <p style="color: green;"><%= message %></p>
            <%
                }
            %>

            <%
                String error = request.getParameter("status");
                if (error != null && error.equals("error")){
            %>
            <p style="color: red">Enter usernames correctly.</p>
            <%
                }
            %>
        </div>

        <div class="customer-table">
            <div class="details">
                <table>
                    <caption>Customers</caption>
                    <thead>
                    <tr>
                        <th>UId</th>
                        <th>Name</th>
                        <th>Email-Address</th>
                        <th>Current-Balance</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        // Fetch all users from the database
                        List<User> users = new UserFunctions().getAllUsers();
                        for (User user : users) {
                    %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getUsername() %></td>
                        <td><%= user.getEmailID() %></td>
                        <td><%= user.getCurrent_balance() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>

<script src="assets/js/main.js"></script>
</body>

</html>

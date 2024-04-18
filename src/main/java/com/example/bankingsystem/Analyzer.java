package com.example.bankingsystem;

import com.example.Connectivity.ConnectDB;
import com.example.Connectivity.Queries;
import com.example.DAO.Transaction;
import com.example.DAO.UserFunctions;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Analyzer", value = "/analyze")
public class Analyzer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFunctions validUser = new UserFunctions();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        double amount = Double.parseDouble(request.getParameter("amount"));

        if (validUser.isValidUser(sender) && validUser.isValidUser(receiver)) {
            try {
                connection = ConnectDB.connectDB();

                // Start transaction
                connection.setAutoCommit(false);

                // Update sender's balance (deduct amount)
                pstmt = connection.prepareStatement(Queries.update_sender_amount);
                pstmt.setDouble(1, amount);
                pstmt.setString(2, sender);
                pstmt.executeUpdate();

                // Update receiver's balance (add amount)
                pstmt = connection.prepareStatement(Queries.update_receiver_amount);
                pstmt.setDouble(1, amount);
                pstmt.setString(2, receiver);
                pstmt.executeUpdate();

                // Commit the transaction
                connection.commit();

                // Store the transaction details in a Transaction object
                Transaction transaction = new Transaction(sender, receiver, amount);

                // Retrieve all transactions from the session or create a new list
                HttpSession session = request.getSession();
                List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
                if (transactions == null) {
                    transactions = new ArrayList<>();
                }
                // Add the current transaction to the list
                transactions.add(transaction);
                // Store the updated list in the session
                session.setAttribute("transactions", transactions);

                // Set success message in the request attribute
                request.setAttribute("message", "Transaction was successful");
                // Forward the request to customer.jsp
                request.getRequestDispatcher("customer.jsp").forward(request, response);
            } catch (SQLException e) {
                // Rollback transaction in case of an error
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
                response.sendRedirect("customer.jsp?status=error");
            } finally {
                // Close prepared statement and connection
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (connection != null) {
                        connection.setAutoCommit(true); // Reset auto-commit
                        connection.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            // If the user is not valid, redirect with an error status
            response.sendRedirect("customer.jsp?status=error");
        }
    }
}

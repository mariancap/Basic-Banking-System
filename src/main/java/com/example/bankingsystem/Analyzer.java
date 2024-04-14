package com.example.bankingsystem;

import com.example.DAO.UserFunctions;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Analyzer", value = "/analyze")
public class Analyzer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFunctions validUser = new UserFunctions();

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        double amount = Double.parseDouble(request.getParameter("amount"));

        if (validUser.isValidUser(sender) && validUser.isValidUser(receiver)) {

            HttpSession session = request.getSession();
            session.setAttribute("Sender", sender);
            session.setAttribute("Receiver", receiver);
            session.setAttribute("Amount", amount);
            response.sendRedirect("customer.jsp?status=success");
        } else {
            response.sendRedirect("customer.jsp?status=error");
        }
    }
}

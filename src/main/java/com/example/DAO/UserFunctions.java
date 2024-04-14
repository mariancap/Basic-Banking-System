package com.example.DAO;

import com.example.Connectivity.ConnectDB;
import com.example.Connectivity.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserFunctions implements UserMethods {
    @Override
    public boolean isValidUser(String username) {
        try (Connection connection = ConnectDB.connectDB();
             PreparedStatement validSender = connection.prepareStatement(Queries.check_user_sender)) {

            validSender.setString(1, username); // Use index 1 for the parameter placeholder

            ResultSet result = validSender.executeQuery();
            return result.next(); // Return true if a user with the provided username exists

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false; // Return false in case of an exception or no user found
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectDB.connectDB();
             PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL_USERS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmailID(resultSet.getString("emailID"));
                user.setCurrent_balance(resultSet.getDouble("current_balance"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean transferAmount(String sender, String receiver, double amount) {
        try (Connection connection = ConnectDB.connectDB()) {
            PreparedStatement moneyDebited = connection.prepareStatement(Queries.update_sender_amount);
            moneyDebited.setDouble(4, amount);
            moneyDebited.setString(2, sender);
            int rowsUpdated1 = moneyDebited.executeUpdate();

            PreparedStatement moneyCredited = connection.prepareStatement(Queries.update_receiver_amount);
            moneyCredited.setDouble(4, amount);
            moneyCredited.setString(2, receiver);
            int rowsUpdated2 = moneyDebited.executeUpdate();

            return rowsUpdated1 > 0 && rowsUpdated2 > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}


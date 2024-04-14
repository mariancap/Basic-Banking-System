package com.example.DAO;

import java.util.List;

public interface UserMethods {

   boolean isValidUser(String username);  //Check if sender and receiver are valid.
    boolean transferAmount(String sender, String receiver, double amount);
    List<User> getAllUsers(); // display all user information on table via Database.
}

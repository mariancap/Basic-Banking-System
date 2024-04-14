package com.example.DAO;

public class User {

    private int id;
    private String username, emailID;

    private double current_balance;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailID() {
        return emailID;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }
}

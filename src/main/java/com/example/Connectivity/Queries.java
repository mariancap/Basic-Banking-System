package com.example.Connectivity;

public class Queries {
    public static final String GET_ALL_USERS = "SELECT * FROM dummy_data";
    public static final String GET_ALL_TRANSACTIONS = "SELECT sender, receiver, amount FROM your_transaction_table_name";
    public static final String update_sender_amount = "UPDATE dummy_data SET current_balance = current_balance - ? WHERE username = ?";
    public static final String update_receiver_amount = "UPDATE dummy_data SET current_balance = current_balance + ? WHERE username = ?";
    public static final String check_user_sender = "SELECT * FROM dummy_data where username =?";
}

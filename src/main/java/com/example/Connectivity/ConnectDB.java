//package com.example.Connectivity;
//
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class ConnectDB {
//
//    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
//    private static final String username = "root";
//    private static final String password = "alone_Hacker/1258";
//    static Connection connection = null;
//
//    public static Connection connectDB(){
//        try{
//            connection = DriverManager.getConnection(url, username, password);
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Connection Established...");
//        return connectDB();
//    }
//}



package com.example.Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static final String url = "jdbc:mysql://localhost:3306/banking_system ";
    private static final String username = "root";
    private static final String password = "alone_Hacker/1258";
    private static Connection connection = null;

    public static Connection connectDB() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection Established...");
            }
        } catch (SQLException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
        }
        return connection;
    }
}

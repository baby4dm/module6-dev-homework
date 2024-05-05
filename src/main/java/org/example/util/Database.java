package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private static String url = "jdbc:postgresql://localhost:5432/mega_soft";
    private static String userName = "postgres";
    private static String password = "postgres";

    private Database(){

    }

    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

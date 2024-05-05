package org.example.service;

import lombok.extern.java.Log;
import org.example.util.Database;
import org.example.util.QueryReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Log
public class DatabaseInitService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        String query = QueryReader.getQueryFromFile("sql/init_db.sql");
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException("Error to create a tables");
        }finally {
            try {
                System.out.println(query);
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Tables was created successfully");
    }


}

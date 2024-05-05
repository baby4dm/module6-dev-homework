package org.example.service;

import lombok.extern.java.Log;
import org.example.util.Database;
import org.example.util.QueryReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Log
public class DatabasePopulateService {

    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        String query = QueryReader.getQueryFromFile("sql/populate_db.sql");
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println(result);
        } catch (SQLException e) {
            throw new RuntimeException("Error to insert data into table");
        }finally {
            try {
                System.out.println(query);
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("The data was inserted successfully");
    }


}

package com.company;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {

    public DatabaseManager() {
        Connection connection = null;
        try {
            String URL = "jdbc:sqlite:src/Data/BookStore.db";
            connection = DriverManager.getConnection(URL);
            System.out.println("Connected");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    void insertAuthor(String name, String email, String url) {

    }


}

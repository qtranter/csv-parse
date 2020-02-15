package com.company;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private String query;
    Connection connection = null;

    public DatabaseManager() {

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
                if (connection == null) {
                    connection.close();
                }
            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    void insertAuthor(String name, String email, String url) throws SQLException {
        query = "INSERT OR IGNORE INTO author(author_name, author_email, author_url) VALUES(?, ?, ?);";
        //preparedStatement = connection.prepareStatement(query);

        PreparedStatement insertAuthor = connection.prepareStatement(query);


        insertAuthor.setString(1, name);
        insertAuthor.setString(2, email);
        insertAuthor.setString(3, url);

        insertAuthor.execute();
    }


}

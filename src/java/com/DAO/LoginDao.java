/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

/**
 *
 * @author azhar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Model.Login;

public class LoginDao {

public String authenticateUser(Login login) throws ClassNotFoundException, SQLException {
    String userRole = null;

    // Ensure the driver is loaded; ideally, this should be handled globally, not here.
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Use try-with-resources to ensure proper closure of resources
    String CHECK_USER_SQL = "SELECT * FROM staff WHERE username = ? AND password = ? AND role = ?";

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cleaning_management", "root", "");
         PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_SQL)) {
        
        preparedStatement.setString(1, login.getUsername());
        preparedStatement.setString(2, login.getPassword());
        preparedStatement.setString(3, login.getRole());

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                userRole = resultSet.getString("role"); // Fetch the role
            }
        }
    } catch (SQLException e) {
        printSQLException(e);
    }
    return userRole;
}


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
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
import java.sql.SQLException;
import com.Model.Register;


public class RegisterDao {

    public int registerRegister(Register register) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO staff"
                + "  (first_name, last_name, username, password, address,email, contact,role) VALUES "
                + " (?, ?, ?, ?, ?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/cleaning_management", "root", ""); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, register.getFirstName());
            preparedStatement.setString(2, register.getLastName());
            preparedStatement.setString(3, register.getUsername());
            preparedStatement.setString(4, register.getPassword());
            preparedStatement.setString(5, register.getAddress());
            preparedStatement.setString(6, register.getEmail());
            preparedStatement.setString(7, register.getContact());
            preparedStatement.setString(8, register.getRole());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

/**
 *
 * @author THINKPAD
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Model.Register;

public class CleanerDAO {

    Connection connection = null;
    private String jdbcURL = "jdbc:mysql://localhost:3306/cleaning_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_REGISTER_BY_ID = "SELECT id, first_name, last_name, username, password,"
            + " address, contact, email, role FROM staff WHERE id = ?";
    private static final String SELECT_ALL_STAFF = "SELECT * FROM staff WHERE role = 'cleaner'";
    ;
    private static final String DELETE_CLEANER_SQL = "delete from staff where id=?";

    private static final String UPDATE_REGISTER_SQL = "UPDATE staff SET first_name=?, last_name=?, username=?, password=?, address=?,email=?, contact=?, role=? where id=?";

    public CleanerDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Register selectRegister(int id) {
        Register register = null;
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REGISTER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String role = rs.getString("role");
                register = new Register(id, firstName, lastName, username, password, address, email, contact, role);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return register;
    }

    public List<Register> selectAllRegister() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Register> registerList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String formatted_id = String.format("C%04d", id);  // Format the ID here
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String email = rs.getString("email");

                String contact = rs.getString("contact");
                String role = rs.getString("role");
                registerList.add(new Register(id,formatted_id, firstName, lastName, username, password, address, email, contact, role));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return registerList;
    }

    public boolean deleteRegister(int id) throws SQLException {
        boolean rowDeleted;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(DELETE_CLEANER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateRegister(Register register) throws SQLException {
        boolean rowUpdated;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(UPDATE_REGISTER_SQL);) {
            statement.setString(1, register.getFirstName());
            statement.setString(2, register.getLastName());
            statement.setString(3, register.getUsername());
            statement.setString(4, register.getPassword());
            statement.setString(5, register.getAddress());
            statement.setString(6, register.getEmail());
            statement.setString(7, register.getContact());
            statement.setString(8, register.getRole());
            statement.setInt(9, register.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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

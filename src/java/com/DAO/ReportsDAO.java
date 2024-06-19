/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Model.Reports;

/**
 *
 * @author azhar
 */
public class ReportsDAO {

    Connection connection = null;
    private String jdbcURL = "jdbc:mysql://localhost:3306/cleaning_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_REPORTS_SQL = "insert into reports(tool,quantity,taskID,description) values "
            + " (?,?,?,?);";

    private static final String SELECT_REPORTS_BY_ID = "select id,tool,quantity,taskID,description from reports where id=?";
    private static final String SELECT_ALL_REPORTS = "select * from reports";
    private static final String SELECT_REPORTS = "select * from reports where taskID=?";
    private static final String DELETE_REPORTS_SQL = "delete from reports where id=?";
    private static final String UPDATE_REPORTS_SQL = "update reports set tool =?, quantity=?, taskID =?, description=? where id=?";

    public ReportsDAO() {
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

    public void insertReports(Reports reports) throws SQLException {
        System.out.println(INSERT_REPORTS_SQL);

        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REPORTS_SQL)) {
            preparedStatement.setString(1, reports.getTool());
            preparedStatement.setInt(2, reports.getQuantity());
            preparedStatement.setInt(3, reports.getTaskid());
            preparedStatement.setString(4, reports.getDescription());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Reports selectReports(int id) {
        Reports report = null;
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REPORTS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String tools = rs.getString("tool");
                int quantity = rs.getInt("quantity");
                int taskid = rs.getInt("taskID");
                String description = rs.getString("description");
                report = new Reports(id, tools, quantity, taskid, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return report;
    }

    public List<Reports> selectAllReports() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Reports> report = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REPORTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String tools = rs.getString("tool");
                int quantity = rs.getInt("quantity");
                int taskid = rs.getInt("taskID");
                String description = rs.getString("description");

                report.add(new Reports(id, tools, quantity, taskid, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return report;
    }

    public List<Reports> listReportsByID(int id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Reports> report = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REPORTS);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                id = rs.getInt("id");
                String tools = rs.getString("tool");
                int quantity = rs.getInt("quantity");
                int taskid = rs.getInt("taskID");
                String description = rs.getString("description");

                report.add(new Reports(id, tools, quantity, taskid, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return report;
    }

    public boolean deleteReports(int id) throws SQLException {
        boolean rowDeleted;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(DELETE_REPORTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateReports(Reports report) throws SQLException {
        boolean rowUpdated;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(UPDATE_REPORTS_SQL)) {
            statement.setString(1, report.getTool());
            statement.setInt(2, report.getQuantity());
            statement.setInt(3, report.getTaskid());
            statement.setString(4, report.getDescription());

            statement.setInt(5, report.getId());

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

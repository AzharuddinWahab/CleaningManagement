/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Model.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUSVIVO
 */
public class TaskDAO {

    Connection connection = null;
    private String jdbcURL = "jdbc:mysql://localhost:3306/cleaning_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String ADD_NEW_TASK = "insert into tasks(customername, customerhpno,"
            + " staffid, buildingtype, date, addnotes) values(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_TASKS_BY_ID = "select id,customername,customerhpno,staffid,buildingtype,"
            + " date, addnotes from tasks where id=?";
    private static final String SELECT_TASKS_ID = "select id from tasks";
    private static final String SELECT_ALL_TASKS = "select * from tasks";
    private static final String DELETE_TASKS = "delete from tasks where id=?";
    private static final String UPDATE_TASK = "update tasks set customername =?, customerhpno=?, staffid =?,"
            + " buildingtype =?, date=?, addnotes=? where id=?";
    private static final String SELECT_TASK = "select * from tasks where id=?";

    public TaskDAO() {
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

    public List<Integer> listTaskID() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Integer> taskIDs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                taskIDs.add(id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return taskIDs;
    }

    public void addNewTasks(Task task) throws SQLException {
        System.out.println(ADD_NEW_TASK);

        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_TASK)) {
            preparedStatement.setString(1, task.getCustomerName());
            preparedStatement.setString(2, task.getCustomerHpNo());
            preparedStatement.setInt(3, task.getStaffid());
            preparedStatement.setString(4, task.getBuildingType());
            preparedStatement.setString(5, task.getDate());
            preparedStatement.setString(6, task.getAddNote());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List< Task> selectAllTasks() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Task> tasks = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String customerName = rs.getString("customername");
                String customerHpNo = rs.getString("customerhpno");
                int staffid = rs.getInt("staffid");
                String formattedStaffId = String.format("C%04d", staffid); // Format staffid here
                String buildingType = rs.getString("buildingtype");
                String date = rs.getString("date");
                String addNote = rs.getString("addnotes");
                tasks.add(new Task(id, customerName, customerHpNo, staffid,formattedStaffId, buildingType, date, addNote));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tasks;
    }

    public Task selectTask(int id) {
        Task task = null;
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String customerName = rs.getString("customername");
                String customerHpNo = rs.getString("customerhpno");
                int staffid = rs.getInt("staffid");
                String buildingType = rs.getString("buildingtype");
                String date = rs.getString("date");
                String addNote = rs.getString("addnotes");
                task = new Task(id, customerName, customerHpNo, staffid, buildingType, date, addNote);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return task;
    }

    public boolean deleteTask(int id) throws SQLException {
        boolean rowDeleted;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(DELETE_TASKS);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateTask(Task task) throws SQLException {
        boolean rowUpdated;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(UPDATE_TASK);) {
            statement.setString(1, task.getCustomerName());
            statement.setString(2, task.getCustomerHpNo());
            statement.setInt(3, task.getStaffid());
            statement.setString(4, task.getBuildingType());
            statement.setString(5, task.getDate());
            statement.setString(6, task.getAddNote());
            statement.setInt(7, task.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List< Task> selectTaskByID(int id) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List< Task> tasks = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                id = rs.getInt("id");
                String customerName = rs.getString("customername");
                String customerHpNo = rs.getString("customerhpno");
                int staffid = rs.getInt("staffid");

                String buildingType = rs.getString("buildingtype");
                String date = rs.getString("date");
                String addNote = rs.getString("addnotes");
                tasks.add(new Task(id, customerName, customerHpNo, staffid, buildingType, date, addNote));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return tasks;
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

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
import java.util.ArrayList;
import java.util.List;
import com.Model.Team;

public class TeamDAO {
    Connection connection = null;
    private String jdbcURL = "jdbc:mysql://localhost:3306/cleaning_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    private static final String INSERT_TEAM_SQL = "insert into team(firstname, lastname,"
            + " ic_no, address, contact, email, reg_date, jobID) values " +
            " (?,?,?,?,?,?,?,?);";
    
    private static final String SELECT_TEAM_BY_ID = "select user_id, firstname, lastname,"
            + " ic_no, address, contact, email, reg_date, jobID from team where user_id=?";
    private static final String SELECT_ALL_TEAM = "select * from team";
    private static final String DELETE_TEAM_SQL = "delete from team where user_id=?";
    private static final String UPDATE_TEAM_SQL = "update team set firstname=?, lastname=?,"
            + " ic_no=?, address=?, contact=?, email=?, reg_date=?, jobID=? where user_id=?";
    
    public TeamDAO(){}
    
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertTeam (Team team) throws SQLException{
        System.out.println(INSERT_TEAM_SQL);
        
        try(Connection connection = getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEAM_SQL)){
            preparedStatement.setString(1, team.getFirstname());
            preparedStatement.setString(2, team.getLastname());
            preparedStatement.setString(3, team.getIc_no());
            preparedStatement.setString(4, team.getAddress());
            preparedStatement.setString(5, team.getContact());
            preparedStatement.setString(6, team.getEmail());
            preparedStatement.setString(7, team.getReg_date());
            preparedStatement.setInt(8, team.getJobid());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        }catch(SQLException e){
            printSQLException(e);
        }
    }
    
    public Team selectTeam(int user_id){
        Team team = null;
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEAM_BY_ID);) {
            preparedStatement.setInt(1, user_id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String ic_no = rs.getString("ic_no");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String reg_date = rs.getString("reg_date");
                int jobid = rs.getInt("jobID");
                team = new Team(user_id, firstname, lastname, ic_no, address, contact, email, reg_date, jobid);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return team;
    }
    
    public List < Team > selectAllTeam() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Team > team = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEAM);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String ic_no = rs.getString("ic_no");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String reg_date = rs.getString("reg_date");
                 int jobid = rs.getInt("jobID");
                team.add(new Team(user_id, firstname, lastname, ic_no, address, contact, email, reg_date, jobid));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return team;
    }
    
    public boolean deleteTeam(int user_id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TEAM_SQL);) {
            statement.setInt(1, user_id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean updateTeam(Team team) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); 
                PreparedStatement statement = connection.prepareStatement(UPDATE_TEAM_SQL);) {
            statement.setString(1, team.getFirstname());
            statement.setString(2, team.getLastname());
            statement.setString(3, team.getIc_no());
            statement.setString(4, team.getAddress());
            statement.setString(5, team.getContact());
            statement.setString(6, team.getEmail());
            statement.setString(7, team.getReg_date());
            statement.setInt(8, team.getJobid());
            statement.setInt(9, team.getUser_id());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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

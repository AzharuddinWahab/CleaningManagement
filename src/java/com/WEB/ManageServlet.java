/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WEB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ReportsDAO;
import com.Model.Reports;
import com.Model.Task;
import com.DAO.TaskDAO;
import com.DAO.CleanerDAO;
import com.Model.Register;

import javax.servlet.http.HttpSession;

/**
 *
 * @author azhar
 */
@WebServlet("/")
public class ManageServlet extends HttpServlet {

    private ReportsDAO reportsDAO;
    private TaskDAO taskDAO;
    private CleanerDAO CleanerDAO;

    public void init() {
        reportsDAO = new ReportsDAO();
        taskDAO = new TaskDAO();
        CleanerDAO = new CleanerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {

                case "/login":
                    logIn(request, response);
                    break;
                case "/home":
                    Home(request, response);
                    break;
                case "/register":
                    register(request, response);
                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertReports(request, response);
                    break;
                case "/delete":
                    deleteReports(request, response);
                    break;
                case "/edit":
                    showEditReportForm(request, response);
                    break;
                case "/listreports":
                    listReports(request, response);
                    break;
                case "/updateReportsbyid":
                    updateReports(request, response);
                    break;
                case "/newTask":
                    showNewTaskForm(request, response);
                    break;
                case "/addnewtask":
                    addNewTask(request, response);
                    break;
                case "/listtask":
                    listTask(request, response);
                    break;
                case "/listtaskbyid":
                    listTaskById(request, response);
                    break;
                case "/edittask":
                    showEditTaskForm(request, response);
                    break;
                case "/deletetask":
                    deleteTask(request, response);
                    break;
                case "/updatetask":
                    updateTask(request, response);
                    break;
                case "/listreportsbyid":
                    listReportsById(request, response);
                    break;
                case "/deleteregister":
                    deleteRegister(request, response);
                    break;
                case "/editstaff":
                    showEditRegisterForm(request, response);
                    break;
                case "/updateregister":
                    updateRegister(request, response);
                    break;
                case "/listRegister":
                    listRegister(request, response);
                    break;
                case "/logout":
                    LogOut(request, response);
                    break;
                case "/homeCleaner":
                    homeCleaner(request, response);
                    break;
                case "/taskListCleaner":
                    taskListCleaner(request, response);
                    break;
                case "/edittaskcleaner":
                    showEditTaskFormCleaner(request, response);
                    break;
                case "/updateTaskCleaner":
                    updateTaskCleaner(request, response);
                    break;
                case "/deletetaskCleaner":
                    deleteTaskCleaner(request, response);
                    break;
                case "/showNewFormCleaner":
                    showNewFormCleaner(request, response);
                    break;
                case "/addNewReport":
                    addNewReport(request, response);
                    break;
                case "/listReportsCleaner":
                    listReportsCleaner(request, response);
                    break;
                case "/listreportsbyidcleaner":
                    listReportsByIdCleaner(request, response);
                    break;
                case "/deleteReportsCleaner":
                    deleteReportsCleaner(request, response);
                    break;
                case "/editReportCleaner":
                    showEditReportFormCleaner(request, response);
                    break;
                case "/updateReportsbyidCleaner":
                    updateReportsCleaner(request, response);
                    break;
//                default:
//                    Home(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void Home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int more = 0;
        List<Task> taskSummary = taskDAO.selectAllTasks();
        if (taskSummary.size() <= 3) {
            more = 0;
        } else {
            more = taskSummary.size() - 3;
        }
        request.setAttribute("taskSummary", taskSummary);
        request.setAttribute("taskcount", taskSummary.size());
        request.setAttribute("more", more);

        List<Register> listRegister = CleanerDAO.selectAllRegister();
        request.setAttribute("listRegister", listRegister);
        request.setAttribute("staffcount", listRegister.size());

        List<Reports> listReports = reportsDAO.selectAllReports();
        request.setAttribute("listReports", listReports);
        request.setAttribute("reportsRecord", listReports.size());

        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        dispatcher.forward(request, response);
    }

    private void LogOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
        dispatcher.forward(request, response);
    }

    private void insertReports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String tools = request.getParameter("tool");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int taskid = Integer.parseInt(request.getParameter("taskid"));
        String description = request.getParameter("description");

        Reports newReports = new Reports(tools, quantity, taskid, description);
        reportsDAO.insertReports(newReports);
        //request.setAttribute("ID", taskid);
        response.sendRedirect("listreportsbyid?id=" + taskid + "");
    }

    private void showEditReportForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reports existingReports = reportsDAO.selectReports(id);
        request.setAttribute("reports", existingReports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateReport.jsp");
        dispatcher.forward(request, response);

    }

    private void updateReports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tools = request.getParameter("tool");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int taskid = Integer.parseInt(request.getParameter("taskid"));
        String description = request.getParameter("description");

        Reports report = new Reports(id, tools, quantity, taskid, description);
        reportsDAO.updateReports(report);
        response.sendRedirect("listreports");
    }

    private void listReports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Reports> listReports = reportsDAO.selectAllReports();
        request.setAttribute("listReports", listReports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReportList.jsp");
        dispatcher.forward(request, response);
    }

    private void listReportsById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List< Reports> listReports = reportsDAO.listReportsByID(id);
        if (listReports.isEmpty()) {
            request.setAttribute("taskid", id);
        } else {
            request.setAttribute("listReports", listReports);
            request.setAttribute("taskid", id);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReportList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addReport.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteReports(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reportsDAO.deleteReports(id);
        response.sendRedirect("listreports");

    }

    private void showNewTaskForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Register> listRegister = CleanerDAO.selectAllRegister();  // Fetch all registered staff
        request.setAttribute("listRegister", listRegister);  // Set staff list in request scope
        RequestDispatcher dispatcher = request.getRequestDispatcher("addTask.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditTaskForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Task existingTask = taskDAO.selectTask(id);
        List<Register> listRegister = CleanerDAO.selectAllRegister();  // Fetch all registered staff
        request.setAttribute("listRegister", listRegister);  // Set staff list in request scope
        request.setAttribute("task", existingTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateTask.jsp");
        dispatcher.forward(request, response);
    }

    private void addNewTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String customerName = request.getParameter("customername");
        String customerHpNo = request.getParameter("customerhpno");
        int staffid = Integer.parseInt(request.getParameter("staffid"));
        String buildingType = request.getParameter("buildingtype");
        String date = request.getParameter("date");
        String addNote = request.getParameter("addnote");
        Task newTask = new Task(customerName, customerHpNo, staffid, buildingType, date, addNote);
        taskDAO.addNewTasks(newTask);
        response.sendRedirect("listtask");
    }

    private void listTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Task> listTasks = taskDAO.selectAllTasks();
        request.setAttribute("listTasks", listTasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("taskList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        taskDAO.deleteTask(id);
        response.sendRedirect("listtask");

    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String customerName = request.getParameter("customername");
        String customerHpNo = request.getParameter("customerhpno");
        int staffid = Integer.parseInt(request.getParameter("staffid"));
        String buildingType = request.getParameter("buildingtype");
        String date = request.getParameter("date");
        String addNote = request.getParameter("addnote");
        Task newTask = new Task(id, customerName, customerHpNo, staffid, buildingType, date, addNote);

        taskDAO.updateTask(newTask);
        response.sendRedirect("listtask");
    }

    private void listTaskById(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List< Task> listTasks = taskDAO.selectTaskByID(id);
        request.setAttribute("listTasks", listTasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tasksList.jsp");
        dispatcher.forward(request, response);
    }

    private void listRegister(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Register> listRegister = CleanerDAO.selectAllRegister();
        request.setAttribute("listRegister", listRegister);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TeamList.jsp");
        dispatcher.forward(request, response);
    }

    private void updateRegister(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String role = request.getParameter("role");

        Register newregister = new Register(id, firstName, lastName, username, password, address, email, contact, role);
        CleanerDAO.updateRegister(newregister);
        response.sendRedirect("listRegister");
    }

    private void showEditRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Register existingRegister = CleanerDAO.selectRegister(id);
        request.setAttribute("register", existingRegister);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateRegister.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteRegister(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CleanerDAO.deleteRegister(id);
        response.sendRedirect("listRegister");
    }

    private void homeCleaner(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int more = 0;
        List<Task> taskSummary = taskDAO.selectAllTasks();
        if (taskSummary.size() <= 3) {
            more = 0;
        } else {
            more = taskSummary.size() - 3;
        }
        request.setAttribute("taskSummary", taskSummary);
        request.setAttribute("taskcount", taskSummary.size());
        request.setAttribute("more", more);

        List<Register> listRegister = CleanerDAO.selectAllRegister();
        request.setAttribute("listRegister", listRegister);
        request.setAttribute("staffcount", listRegister.size());

        List<Reports> listReports = reportsDAO.selectAllReports();
        request.setAttribute("listReports", listReports);
        request.setAttribute("reportsRecord", listReports.size());

        RequestDispatcher dispatcher = request.getRequestDispatcher("homeCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void taskListCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Task> listTasks = taskDAO.selectAllTasks();
        request.setAttribute("listTasks", listTasks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("taskListCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditTaskFormCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Task existingTask = taskDAO.selectTask(id);
        List<Register> listRegister = CleanerDAO.selectAllRegister();  // Fetch all registered staff
        request.setAttribute("listRegister", listRegister);  // Set staff list in request scope
        request.setAttribute("task", existingTask);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateTaskCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void updateTaskCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String customerName = request.getParameter("customername");
        String customerHpNo = request.getParameter("customerhpno");
        int staffid = Integer.parseInt(request.getParameter("staffid"));
        String buildingType = request.getParameter("buildingtype");
        String date = request.getParameter("date");
        String addNote = request.getParameter("addnote");
        Task newTaskCleaner = new Task(id, customerName, customerHpNo, staffid, buildingType, date, addNote);

        taskDAO.updateTask(newTaskCleaner);
        response.sendRedirect("taskListCleaner");
    }

    private void deleteTaskCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        taskDAO.deleteTask(id);
        response.sendRedirect("taskListCleaner");

    }

    private void showNewFormCleaner(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addReportCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void addNewReport(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String tools = request.getParameter("tool");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int taskid = Integer.parseInt(request.getParameter("taskid"));
        String description = request.getParameter("description");

        Reports newReportsCleaner = new Reports(tools, quantity, taskid, description);
        reportsDAO.insertReports(newReportsCleaner);
        //request.setAttribute("ID", taskid);
        response.sendRedirect("listreportsbyidcleaner?id=" + taskid + "");
    }

    private void listReportsCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Reports> listReportsCleaner = reportsDAO.selectAllReports();
        request.setAttribute("listReports", listReportsCleaner);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReportListCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void listReportsByIdCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List< Reports> listReports = reportsDAO.listReportsByID(id);
        if (listReports.isEmpty()) {
            request.setAttribute("taskid", id);
        } else {
            request.setAttribute("listReports", listReports);
            request.setAttribute("taskid", id);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("ReportListCleaner.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditReportFormCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reports existingReportsCleaner = reportsDAO.selectReports(id);
        request.setAttribute("reports", existingReportsCleaner);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateReportCleaner.jsp");
        dispatcher.forward(request, response);

    }

    private void updateReportsCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tools = request.getParameter("tool");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int taskid = Integer.parseInt(request.getParameter("taskid"));
        String description = request.getParameter("description");

        Reports reportCleaner = new Reports(id, tools, quantity, taskid, description);
        reportsDAO.updateReports(reportCleaner);
        response.sendRedirect("listReportsCleaner");
    }

    private void deleteReportsCleaner(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        reportsDAO.deleteReports(id);
        response.sendRedirect("listReportsCleaner");

    }

}

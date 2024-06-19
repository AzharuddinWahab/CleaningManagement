/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WEB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Login;
import com.DAO.LoginDao;

/**
 *
 * @author azhar
 */
@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        login.setRole(role);

        try {
            String userRole = loginDao.authenticateUser(login);
            HttpSession session = request.getSession();
            if (userRole != null) {
                session.setAttribute("role", userRole);  // Store role in session
                if ("admin".equals(userRole)) {
                    response.sendRedirect("home"); // Redirect to admin page
                } else if ("cleaner".equals(userRole)) {
                    response.sendRedirect("homeCleaner"); // Redirect to cleaner page
                }
            } else {
                session.setAttribute("loginFailed", "Invalid username or password");
                response.sendRedirect("login"); // Redirect back to the login page
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

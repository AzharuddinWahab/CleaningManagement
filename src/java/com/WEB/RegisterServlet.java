/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WEB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.RegisterDao;
import com.Model.Register;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author azhar
 */
@WebServlet("/registerUser")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;

    public void init() {
        registerDao = new RegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String role = "cleaner";

        Register register = new Register();
        register.setFirstName(firstName);
        register.setLastName(lastName);
        register.setUsername(username);
        register.setPassword(password);
        register.setContact(contact);
        register.setAddress(address);
        register.setEmail(email);
        register.setRole(role);

        try {
            registerDao.registerRegister(register);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("successRegister.jsp");
    }
}

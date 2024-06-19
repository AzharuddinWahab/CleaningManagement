<%-- 
    Document   : TeamList
    Created on : Jun 14, 2021, 10:58:58 AM
    Author     : THINKPAD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cleaning Service Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <style>
            .navbar-dark .navbar-nav .nav-link {
                font-size: 1em;
                margin-right: 15px;
                color: #ffffff;
            }
            .navbar-dark .navbar-nav .nav-item.active .nav-link {
                background-color: #5DA0CE;
                border-radius: 5px;
                color: #ffffff;
                font-weight: bold;
            }
            .navbar-dark .navbar-nav .nav-link:hover {
                background-color: #00e6e6;
                color: white;
                border-radius: 5px;
            }
            .navbar-brand {
                font-weight: bold;
                font-size: 1.35em;
            }
            .btn-dark {
                background-color: #002633;
                border-color: #002633;
            }
            .first-row {
                background-color: #99ccff;
            }
            .action-button {
                background-color: #006666;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .action-btnremove {
                background-color: red;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .action-button:hover {
                background-color: #006666;
                color: white;
            }
            .action-btnremove:hover {
                background-color: red;
                color: white;
            }
            .header-row {
                background-color: #003333;
                color: white;
            }
        </style>
    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #009999;">
            <a class="navbar-brand font-weight-bold" href="#">Cleaning Service Management System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ${pageContext.request.requestURI.endsWith('home') ? 'active' : ''}">
                        <a class="nav-link" href="home">Home</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI.endsWith('listRegister') ? 'active' : ''}">
                        <a class="nav-link" href="listRegister">Staffs</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI.endsWith('listtask') ? 'active' : ''}">
                        <a class="nav-link" href="listtask">Tasks</a>
                    </li>
                    <li class="nav-item ${pageContext.request.requestURI.endsWith('listreports') ? 'active' : ''}">
                        <a class="nav-link" href="listreports">Reports</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link btn btn-dark text-white" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <body style="background-color: #e6ffff;">
        <div class="container mt-4">
            <div class="row">
                <div class="col-12">
                    <h2 class="text-center">List of Registered Staff</h2>
                    <hr>
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr class="header-row">
                                    <th>#</th>
                                    <th>Staff ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>Address</th>
                                    <th>Email</th>
                                    <th>Contact</th>
                                    <th>Role</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="register" items="${listRegister}" varStatus="status">
                                    <tr class="<c:if test='${status.count == 1}'>first-row</c:if>">
                                        <td>${status.count}</td>
                                        <td><c:out value="${register.formatted_id}" /></td>
                                        <td><c:out value="${register.firstName}" /></td>
                                        <td><c:out value="${register.lastName}" /></td>
                                        <td><c:out value="${register.username}" /></td>
                                        <td><c:out value="${register.password}" /></td>
                                        <td><c:out value="${register.address}" /></td>
                                        <td><c:out value="${register.email}" /></td>
                                        <td><c:out value="${register.contact}" /></td>
                                        <td><c:out value="${register.role}" /></td>
                                        <td>
                                            <div class="mb-2">
                                                <a href="editstaff?id=${register.id}" class="action-button">Edit Staff's Profile</a>
                                            </div>
                                            <div>
                                                <a href="deleteregister?id=${register.id}" class="action-btnremove">Remove Staff</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : EmployeeList
    Created on : Jun 9, 2021, 9:48:03 AM
    Author     : NAD
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cleaning Service Management System</title>
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
            .custom-btn {
                background-color: #006666;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-btnTOP {
                background-color: #006666;
                color: white;
                padding: 5px 10px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-delete {
                background-color: red;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-delete:hover {
                color: white;
                background-color: red;
            }
            .custom-btn:hover {
                color: white;
                background-color: #006666;
            }
            .custom-btnTOP:hover {
                color: white;
                background-color: #006666;
            }

            .custom-table-header {
                background-color: #003333;
                color: white;
            }
            .action-column {
                width: 150px; /* Adjust as needed */
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

        <br>
        <h2 align="center">Report Records</h2>
        <hr>

        <div style="margin-right: 5%; margin-left: 5%;">

            <c:if test="${taskid != null}">
                <a href="<%=request.getContextPath()%>/new?id=<c:out value='${taskid}' />" class="custom-btnTOP">Add New Reports</a>
            </c:if>
            <c:if test="${taskid == null}">
                <a href="listtask" class="custom-btnTOP">Add New Reports to a Task</a>
            </c:if>

            <br>
            <br>
            <table class="table table-bordered table-striped">
                <thead class="custom-table-header">
                    <tr>
                        <th>#</th>
                        <th>ID</th>
                        <th>Tools Type</th>
                        <th>Quantity</th>
                        <th>Task ID</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reports" items="${listReports}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>R<c:out value="${reports.id}" /></td>
                            <td><c:out value="${reports.tool}" /></td>
                            <td><c:out value="${reports.quantity}" /></td>
                            <td>T<c:out value="${reports.taskid}" /></td>
                            <td><c:out value="${reports.description}" /></td>
                            <td class="action-column">
                                <div class="mb-2">
                                    <a href="edit?id=<c:out value='${reports.id}' />" class="custom-btn">Edit Report</a>
                                </div>
                                <div class="mb-2">
                                    <a href="delete?id=<c:out value='${reports.id}' />" class="custom-delete">Remove Report</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

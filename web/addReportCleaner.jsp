<%-- 
    Document   : EmployeeList
    Created on : Jun 9, 2021, 9:48:03 AM
    Author     : NAD
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            .custom-save {
                background-color: green;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-reset {
                background-color: yellow;
                color: black;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-cancel {
                background-color: red;
                color: white;
                padding: 6px 10px;
                border-radius: 5px;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #009999;">
                <a class="navbar-brand font-weight-bold" href="#">Cleaning Service Management System</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="homeCleaner">Home</a>
                        </li>
                    </ul>
                </div>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link btn btn-dark text-white" href="logout">Logout</a>
                    </li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${reports != null}">
                        <form action="addNewReport" method="post">
                        </c:if>
                        <c:if test="${reports == null}">
                            <form action="addNewReport" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${reports != null}">
                                        Edit reports
                                    </c:if>
                                    <c:if test="${reports == null}">
                                        Add New Reports
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${reports != null}">
                                <input type="hidden" name="id" value="<c:out value='${reports.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Tools Type</label>
                                <input type="text" value="<c:out value='${reports.tool}' />" class="form-control" name="tool" required="required" placeholder="Enter Tools Type">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Quantity</label>
                                <input type="number" value="<c:out value='${reports.quantity}' />" class="form-control" name="quantity" placeholder="Enter Quantity">
                            </fieldset>

                            <fieldset class="form-group">
                                <c:if test="${reports != null}">
                                    <label>Job ID</label>
                                    <input type="text" value="<c:out value='${reports.taskid}' />" class="form-control" name="taskid" placeholder="Enter Job ID">
                                </c:if>
                                <c:if test="${reports == null}">
                                    <label>Task ID</label>
                                    <input type="text" value="<c:out value='${id}' />" class="form-control" name="taskid" readonly placeholder="Enter Task ID">
                                </c:if>
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Description</label>
                                <input type="text" value="<c:out value='${reports.description}' />" class="form-control" name="description" required="required" placeholder="Enter Description">
                            </fieldset>

                            <input type="submit" class="custom-save btn-success" value="Save"></input>
                            <input type="reset" class="custom-reset btn-warning" value="Reset"></input>
                            <a href="listreports" class="custom-cancel btn-danger">Cancel</a>
                        </form>
                </div>
            </div>
        </div>
    </body>

</html>
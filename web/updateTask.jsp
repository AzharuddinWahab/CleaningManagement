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
        <meta charset="utf-8">
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
    <caption>
        <h2 style="text-align: center;">
            <c:if test="${tools != null}">
                Edit Task
            </c:if>
            <c:if test="${tools == null}">
                Update Task
            </c:if>
        </h2>
    </caption>
    <br>
    <br>
    <c:if test="${task != null}">
        <form action="updatetask" method="post" style="margin-right: 20%; margin-left: 20%;">
        </c:if>

        <c:if test="${task != null}">
            <input type="hidden" name="id" value="<c:out value='${task.id}' />" />
        </c:if>
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label" required="required">Client's Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="<c:out value='${task.customerName}' />" id="inputEmail3" name="customername">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail4" class="col-sm-2 col-form-label" required="required">Client's Contact</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="<c:out value='${task.customerHpNo}' />" id="inputEmail4" name="customerhpno">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail5" class="col-sm-2 col-form-label" required="required">Assigned Staff</label>
            <div class="col-sm-10">
                <select class="form-control" id="staffid" name="staffid">
                    <option disabled selected>Select a staff to complete this task</option>
                    <c:forEach items="${listRegister}" var="register">
                        <option value="${register.id}" ${task != null && task.staffid == register.id ? 'selected' : ''}>
                            ${register.firstName} ${register.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Building Type</label>
            <div class="col-sm-10">
                <select class="form-control" name="buildingtype" required="required">
                    <c:if test="${task == null}">
                        <option disabled selected>Select the building type</option>
                        <option value="Small House">Small House</option>
                        <option value="Medium-size House">Medium Size House (has 3 Bedrooms)</option>
                        <option value="Big House">Big House (has 4 or more bedrooms)</option>
                        <option value="Small Office Room">Small Office Room</option>
                        <option value="Big Office Room">Big Office Rooms</option>
                    </c:if>
                    <c:if test="${task != null}">
                        <c:if test="${task.buildingType == 'Small House'}">
                            <option disabled>Select Building Type</option>
                            <option value="Small House" selected>Small House</option>
                            <option value="Medium-size House">Medium Size House (has 3 Bedrooms)</option>
                            <option value="Big House">Big House (has 4 or more bedrooms)</option>
                            <option value="Small Office Room">Small Office Room</option>
                            <option value="Big Office Room">Big Office Rooms</option>
                        </c:if>
                        <c:if test="${task.buildingType == 'Medium-size House'}">
                            <option disabled>Select Building Type</option>
                            <option value="Small House">Small House</option>
                            <option value="Medium-size House" selected>Medium Size House (has 3 Bedrooms)</option>
                            <option value="Big House">Big House (has 4 or more bedrooms)</option>
                            <option value="Small Office Room">Small Office Room</option>
                            <option value="Big Office Room">Big Office Rooms</option>
                        </c:if>
                        <c:if test="${task.buildingType == 'Big House'}">
                            <option disabled>Select Building Type</option>
                            <option value="Small House">Small House</option>
                            <option value="Medium-size House">Medium Size House (has 3 Bedrooms)</option>
                            <option value="Big House" selected>Big House (has 4 or more bedrooms)</option>
                            <option value="Small Office Room">Small Office Room</option>
                            <option value="Big Office Room">Big Office Rooms</option>
                        </c:if>
                        <c:if test="${task.buildingType == 'Small Office Room'}">
                            <option disabled>Select Building Type</option>
                            <option value="Small House">Small House</option>
                            <option value="Medium-size House">Medium Size House (has 3 Bedrooms)</option>
                            <option value="Big House">Big House (has 4 or more bedrooms)</option>
                            <option value="Small Office Room" selected>Small Office Room</option>
                            <option value="Big Office Room">Big Office Rooms</option>
                        </c:if>  
                        <c:if test="${task.buildingType == 'Big Office Room'}">
                            <option disabled>Select Building Type</option>
                            <option value="Small House">Small House</option>
                            <option value="Medium-size House">Medium Size House (has 3 Bedrooms)</option>
                            <option value="Big House">Big House (has 4 or more bedrooms)</option>
                            <option value="Small Office Room">Small Office Room</option>
                            <option value="Big Office Room" selected>Big Office Rooms</option>
                        </c:if>
                    </c:if>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail7" class="col-sm-2 col-form-label" required="required">Allocated Date</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" value="<c:out value='${task.date}' />" id="inputEmail5" name="date">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputEmail7" class="col-sm-2 col-form-label">Additional Notes/Request</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="<c:out value='${task.addNote}' />" id="inputEmail6" name="addnote" value="None">
            </div>
        </div>
        <br>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" class="custom-save btn-success" value="Save"></input>
                <input type="reset" class="custom-reset btn-warning" value="Reset"></input>
                <a href="listtask" class="custom-cancel btn-danger">Cancel</a>
            </div>
        </div>
    </form>
</body>
</html>

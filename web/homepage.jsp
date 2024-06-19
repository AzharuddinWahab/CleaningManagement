<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
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
        
        </br>
        <div class="container">
            <div align="center">
                <h1>Management Overview</h1>
                <table class="table table-bordered" style="margin-top: 10px;text-align: center;">
                    <colgroup>
                        <col style="background-color:#00e6e6">
                        <col style="background-color:#00b3b3">
                        <col style="background-color:#00e6e6">
                    </colgroup>
                    <thead>
                        <tr>
                            <th style="color: #000000; border: 1px solid #ffffff;">Tasks to be Completed</th> 
                            <th style="color: #000000; border: 1px solid #ffffff;">Staffs Registered</th>
                            <th style="color: #000000; border: 1px solid #ffffff;">Assigned Reports Record</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <tr style="font-size: 50px;">
                            <td style="color: #000000; border: 1px solid #ffffff;"><c:out value='${taskcount}' /></td> 
                            <td style="color: #000000; border: 1px solid #ffffff;"><c:out value='${staffcount}' /></td> 
                            <td style="color: #000000; border: 1px solid #ffffff;"><c:out value='${reportsRecord}' /></td> 
                        </tr>
                    </tbody>
                </table>
                <br>
                <br>

                <h1>Tasks Summary</h1>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr class="bg-info">
                            <th style="border: 1px solid #ffffff;">Task ID</th> 
                            <th style="border: 1px solid #ffffff;">Staff In Charge</th>
                            <th style="border: 1px solid #ffffff;">Bookings Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="task" items="${taskSummary}">
                            <tr>
                                <td style="border: 2px solid #ffffff;">T<c:out value="${task.id}" /></td>
                                <td style="border: 2px solid #ffffff;"><c:out value="${task.formattedStaffId}" /></td>
                                <td style="border: 2px solid #ffffff;"><c:out value="${task.date}" /></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p align="left" style="font-style: italic; font-size: 20px;">
                    <c:if test="${more == 0}">
                    <p></p>
                </c:if>
                <c:if test="${more != 0}">
                    <p><c:out value="${more}" /></p>
                </c:if>
                </p>
            </div>
            <div align="center" style="margin-top: 60px;">
                <ul>
                    <a href="listtask"><button type="button" class="btn btn-primary" style="background-color: #006666 !important;">View All Tasks</button></a>
                    <a href="listRegister"><button type="button" class="btn btn-primary" style="background-color: #006666 !important;">View Staff List</button></a>
                    <a href="listreports"><button type="button" class="btn btn-primary" style="background-color: #006666 !important;">View Reports</button></a>
                </ul>
            </div>
        </div>

    </body>
</html>


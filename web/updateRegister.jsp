<%-- 
    Document   : adminRegister
    Created on : May 7, 2024, 6:02:03 PM
    Author     : azhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            .custom-submit {
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
                padding: 2.5px 5px;
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
        <div class="container col-md-5" align="center">
            <h1>Edit Staff's Profile</h1>
            <div class="card">
                <div class="card-body">
                    <form action="updateregister" method="post">
                        <input type="hidden" name="id" value="${register.id}" />

                        <table style="width: 80%">

                            <tr>
                                <td>First Name</td>
                                <td><input type="text" name="firstName" value="${register.firstName}" class="form-control" id="firstName" /></td>
                            </tr>

                            <tr>
                                <td>Last Name</td>
                                <td><input type="text" name="lastName" value="${register.lastName}" class="form-control" id="lastName" /></td>
                            </tr>

                            <div class="form-group">
                                <label for="role">Role:</label>
                                <input type="text" name="role" value="${register.role}" class="form-control" id="role" readonly />
                            </div>

                            <tr>
                                <td>UserName</td>
                                <td><input type="text" name="username" class="form-control" value="${register.username}" /></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password" class="form-control" value="${register.password}" /></td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><input type="text" name="address" class="form-control" value="${register.address}" /></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><input type="text" name="email" class="form-control" value="${register.email}" /></td>
                            </tr>

                            <tr>
                                <td>Contact No</td>
                                <td><input type="text" name="contact" class="form-control" value="${register.contact}" /></td>
                            </tr>

                        </table>
                        <br>
                        <ul>
                            <button type="submit" class="custom-submit btn-success">Update</button>
                            <button type="reset" class="btn-warning custom-reset">Reset</button>
                            <a href="listRegister"><button type="button" class="btn-danger custom-cancel">Cancel</button></a>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

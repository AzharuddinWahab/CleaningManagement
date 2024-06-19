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
            .custom-button {
                background-color: #008080;
                color: white;
                padding: 5px 10px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-button:hover {
                color: white;
                background-color: #006666;
            }
            body {
                background-color: #e6ffff;
            }
            .container {
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                margin-top: 50px;
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
            .login_btn {
                background-color: green;
                color: white;
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

                    </ul>

                </div>
            </nav>
        </header>
        <div class="container col-md-5 mt-5">
            <h1 class="text-center">Employee Register Form</h1>
            <div class="card">
                <div class="card-body">
                    <form action="registerUser" method="post">
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter First Name" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter Last Name" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" name="address" class="form-control" id="address" placeholder="Enter Address" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" name="email" class="form-control" id="email" placeholder="Enter Email" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="contact">Contact No</label>
                            <input type="text" name="contact" class="form-control" id="contact" placeholder="Enter Contact Number" required="required"/>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-success">Submit</button> 
                            <button type="reset" class="btn btn-warning">Reset</button> 
                            <a href="login" class="btn btn-danger">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

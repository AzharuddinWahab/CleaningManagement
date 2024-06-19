<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Successful</title>
    <!-- Link to Bootstrap CSS for styling -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 400px;
            padding: 15px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,.05);
        }
        .btn-custom {
            font-weight: bold;
            color: white;
            background-color: #007BFF;
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <h1 class="h3 mb-3 font-weight-normal">Cleaner Successfully Registered!</h1>
        <p class="lead">You can now log in to the system using your credentials.</p>
        <a href="login" class="btn btn-lg btn-custom">Login</a>
    </div>
    <!-- Optional: Add automatic redirection to login page after 5 seconds -->
    <script>
        setTimeout(function(){
            window.location.href = 'login';
        }, 5000);
    </script>
</body>
</html>

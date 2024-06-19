<%-- 
    Document   : error.jsp
    Created on : Jun 9, 2021, 9:54:15 AM
    Author     : NAD
--%>
<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
    <center>
        <h1>Error</h1>
        <h2><%=exception.getMessage()%><br/> </h2>
    </center> 
</body>
</html>

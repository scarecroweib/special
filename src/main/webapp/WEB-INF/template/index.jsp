<%-- 
    Document   : index
    Created on : 2016-8-17, 15:18:11
    Author     : zhangjingwei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome Special Project!</h1>
        <hr>
        <form method="POST">
            User:<input type="text" name="username" value="" /><br>
            Password:<input type="password" name="password" value="" /><br>
            <input type="submit" value="Sign in" /> <a href="/register">Sign Up</a>
        </form>
    </body>
</html>

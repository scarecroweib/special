<%-- 
    Document   : index
    Created on : 2016-8-17, 15:18:11
    Author     : zhangjingwei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
        <c:if test="autherror != null" >
            <div><s:message code="autherror" /></div>
        </c:if>
        <sf:form method="POST" commandName="authInfo">
            Account:<sf:input path="account" /><br>
            Password:<sf:password path="password" /><br>
            <input type="submit" value="Sign in" /> <a href="/register">Sign Up</a>
        </sf:form>
    </body>
</html>

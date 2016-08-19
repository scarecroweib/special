<%-- 
    Document   : form
    Created on : 2016-8-18, 11:48:30
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
        <link rel="stylesheet" type="text/css" href="<s:url value="/public/css/mod.css" />" />
        <title><s:message code="System.title" /></title>
    </head>
    <body>
        <h1><s:message code="register.title" /></h1>
        <hr>
        <sf:form method="POST" commandName="user">
            <s:message code="register.tag.firstName" /><sf:input path="firstName" /><sf:errors path="firstName" /><br>
            <s:message code="register.tag.lastName" /><sf:input path="lastName" /><sf:errors path="lastName" /><br>
            <s:message code="register.tag.nickname" /><sf:input path="nickname" /><sf:errors path="nickname" /><br>
            <s:message code="register.tag.email" /><sf:input path="email" /><sf:errors path="email" /><br><br><br>
            <s:message code="register.tag.account" /><sf:input path="account" /><sf:errors path="account" /><br>
            <s:message code="register.tag.password" /><sf:password path="password" /><sf:errors path="password" /><br>
            <br>
            <input type="submit" value="<s:message code="register.btn.commit" />" />
            <a href="<s:url value="/" />" ><s:message code="register.btn.cancel" /> </a>
        </sf:form>
    </body>
</html>

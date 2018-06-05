<%--
  Created by IntelliJ IDEA.
  User: jeremy benzakein
  Date: 06/05/2018
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <script type="text/javascript" src="../scripts/index.js"></script>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <p>UserId:    ${user.id}</p>
        <p>UserFName: ${user.firstName}</p>
        <p>UserLName: ${user.lastName}</p>
        <p>UserMail:  ${user.email}</p>
        <p>UserPass:  ${user.passwordHash}</p>
        <p>UserRole:  ${user.role}</p>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

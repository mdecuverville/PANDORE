<%--
  Created by IntelliJ IDEA.
  User: jeremy benzakein
  Date: 06/05/2018
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <security:authorize access="isAuthenticated()">
            user : <security:authentication property="principal.username" />
            role : <security:authentication property="principal.authorities" />
        </security:authorize>
        <table id="panneau">
            <thead>
                <tr>
                    <th>Message</th>
                    <th>Emetteur</th>
                    <th>Date/heure</th>
                    <th>Likes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mes" items="${allMessages}">
                    <tr>
                        <td>
                            <div><b>${mes.title}</b></div>
                            <div>${mes.content}</div>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${mes.anonymous}">
                                    anonyme
                                </c:when>
                                <c:otherwise>
                                    ${mes.createdBy.firstName} ${mes.createdBy.lastName}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            ${mes.createdAt}
                        </td>
                        <td>
                            <div>${mes.likes.size()}</div>
                            <div><a onclick="likeMessage">liker</a></div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <security:authorize access="hasRole('ADMIN')">
            <p>I AM AN ADMIN</p>
        </security:authorize>

        <security:authorize access="hasRole('TEACHER')">
            <p>I AM AN TEACHER</p>
        </security:authorize>

        <security:authorize access="hasRole('STUDENT')">
            <p>I AM AN STUDENT</p>
        </security:authorize>

        <security:authorize access="hasRole('ADMINISTRATOR')">
            <p>I AM AN ADMINISTRATOR</p>
        </security:authorize>

    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

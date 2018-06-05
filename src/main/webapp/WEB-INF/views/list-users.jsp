<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <script type="text/javascript" src="scripts/index.js"></script>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-dark" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <table>
            <tr>
                <th>id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Password</th>
                <th>Role</th>
            </tr>
        <c:forEach var="user" items="${users}" >
            <%--Link for updates--%>
            <c:url var="updateLink" value="/user/update" >
                <c:param name="userId" value="${user.id}" />
            </c:url>

            <%--Link for deletes--%>
            <c:url var="deleteLink" value="/user/delete" >
                <c:param name="userId" value="${user.id}" />
            </c:url>
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.passwordHash}</td>
                <td>${user.role}</td>
                <td><%-- display the link for update --%>
                    <a href="${updateLink}">Update</a> |
                    <a href="${deleteLink}" onclick="if(!(confirm('Are you sure to delete this user ?'))) return false" >Delete</a>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <div >
            <h3>Save user</h3>
            <form:form action="save" modelAttribute="user" method="post" >
                <table>
                    <tbody>
                    <form:hidden path="id" />
                    <tr>
                        <td><label for="firstname">Firstname :</label></td>
                        <td><form:input name="firstname" path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label for="lastname">Lastname :</label></td>
                        <td><form:input name="lastname" path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email :</label></td>
                        <td><form:input name="email" path="email"/></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password :</label></td>
                        <td><form:password name="password" path="passwordHash"/></td>
                    </tr>
                    <tr>
                        <td><label for="roleName">Role :</label></td>
                        <td>
                            <form:select name="roleName" path="role">
                                <form:option value="Administration" label="Administration" />
                                <form:option value="teacher" label="professeur" />
                                <form:option value="student" label="Etudiant" />
                                <form:option value="Admin" label="Administrateur" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" /></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>

            <div style="clear: both"></div>

            <p>
                <a href="${pageContext.request.contextPath}/user/list">Back to list</a>
            </p>

        </div>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>
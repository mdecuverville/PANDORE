<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/in"></script>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <jsp:include page="${pageContext.request.contextPath}/shared/header.jsp" flush="true" />
    </div>
    <div id="body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Role</th>
                <th></th>

            </tr>
            </thead>
            <tbody>
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
                    <td scope="row">${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td><%-- display the link for update --%>
                        <a href="${updateLink}">Update</a> |
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure to delete this user ?'))) return false" >Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="footer">
        <jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
    </div>
</div>
</body>
</html>
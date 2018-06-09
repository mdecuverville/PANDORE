<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Users</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <div style="padding:15px">
            <a class="btn btn-success" href="/user/add">Nouveau User</a>
        </div>
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Password</th>
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
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="#" data-toggle="modal" data-target="#pwModal${user.id}">see hash</a>
                            <div class="modal fade" id="pwModal${user.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">${user.firstName} ${user.lastName} : password</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" style="word-wrap: break-word;">
                                            <div>${user.passwordHash}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td>${user.role}</td>
                        <td><%-- display the link for update --%>
                            <a href="${updateLink}" class="btn btn-info">Update</a>
                            <a href="${deleteLink}" class="btn btn-danger" onclick="if(!(confirm('Are you sure to delete this user ?'))) return false" >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

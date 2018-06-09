<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Likes</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <div style="padding:15px">
            <a class="btn btn-success" href="#">Nouveau Like</a>
        </div>
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>By</th>
                    <th>Message</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="likes" items="${likes}" >
                    <tr>
                        <td>${likes.id}</td>
                        <td>${likes.likedBy.firstName}</td>
                        <td>${likes.likedMessage.id} : ${likes.likedMessage.title}</td>
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
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>
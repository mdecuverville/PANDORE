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
                <th>Name</th>
            </tr>
            <c:forEach var="category" items="${categories}" >
                <%--Link for updates--%>
                <c:url var="updateLink" value="/category/update" >
                    <c:param name="categoryId" value="${category.id}" />
                </c:url>

                <%--Link for deletes--%>
                <c:url var="deleteLink" value="/category/delete" >
                    <c:param name="categoryId" value="${category.id}" />
                </c:url>
                <tr>
                    <td>${category.id}</td>
                    <td>${category.categoryName}</td>
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
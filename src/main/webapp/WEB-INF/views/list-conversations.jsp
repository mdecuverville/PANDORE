<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Conversations</title>
</head>
<body class="bg-info" style="color: #dddddd"><div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="conversation" items="${conversations}" >
                    <%--Link for updates--%>
                    <c:url var="updateLink" value="conversation/update" >
                        <c:param name="conversationId" value="${conversation.id}" />
                    </c:url>

                    <%--Link for deletes--%>
                    <c:url var="deleteLink" value="conversation/delete" >
                        <c:param name="conversationId" value="${conversation.id}" />
                    </c:url>
                    <tr>
                        <td>${conversation.id}</td>
                        <td>${conversation.conversationName}</td>
                        <td><%-- display the link for update --%>
                            <a href="${updateLink}">Update</a> |
                            <a href="${deleteLink}" onclick="if(!(confirm('Are you sure to delete this user ?'))) return false" >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>
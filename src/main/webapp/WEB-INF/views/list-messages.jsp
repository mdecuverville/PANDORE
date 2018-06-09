<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Messages</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>title</th>
                    <th>content</th>
                    <th>createdAt</th>
                    <th>createdBy</th>
                    <th>likes</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="message" items="${messages}" >
                    <%--Link for updates--%>
                    <c:url var="updateLink" value="/message/update" >
                        <c:param name="messageId" value="${message.id}" />
                    </c:url>

                    <%--Link for deletes--%>
                    <c:url var="deleteLink" value="/message/delete" >
                        <c:param name="messageId" value="${message.id}" />
                    </c:url>
                    <tr>
                        <td>${message.id}</td>
                        <td>${message.title}</td>
                        <td>
                            <a href="#" data-toggle="modal" data-target="#contentModal${message.id}">see content</a>
                            <div class="modal fade" id="contentModal${message.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">${message.title} : content</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body" style="word-wrap: break-word;">
                                            <div>${message.content}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td>${message.createdAt}</td>
                        <td>${message.createdBy.firstName} ${message.createdBy.lastName}</td>
                        <td>${message.likes.size()}</td>
                        <td><%-- display the link for update --%>
                            <a href="${updateLink}" class="btn btn-info">Update</a>
                            <a href="${deleteLink}" class="btn btn-danger" onclick="if(!(confirm('Are you sure to delete this message ?'))) return false" >Delete</a>
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
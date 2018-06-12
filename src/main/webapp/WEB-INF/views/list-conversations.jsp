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
        <div style="padding:15px">
            <a class="btn btn-success" href="/conversation/add">Nouvelle Conversation</a>
        </div>
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Members</th>
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
                        <td>
                            <a href="#usersModal${conversation.id}" data-toggle="modal" data-target="#usersModal${conversation.id}">see members (${conversation.usersIn.size()})</a>
                            <div class="modal fade" id="usersModal${conversation.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title"> ${conversation.conversationName} : members</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="memberTable" style="width:90%">
                                                <thead>
                                                    <tr>
                                                        <th>UserId</th>
                                                        <th>email</th>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="usr" items="${conversation.usersIn}">
                                                    <tr>
                                                        <td>${usr.id}</td>
                                                        <td>${usr.email}</td>
                                                        <td><button class="btn btn-danger">Kick Out</button></td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td colspan="3">
                                                        <select>
                                                            <c:forEach var="convMember" items="${allUsers}">
                                                                <option value="${convMember.id}">${convMember.email}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <a href="#" class="btn btn-info">add new member</a>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td><%-- display the link for update --%>
                            <a href="${updateLink}" class="btn btn-info">Update</a>
                            <a href="${deleteLink}" class="btn btn-danger" onclick="if(!(confirm('Are you sure to delete this conversation ?'))) return false" >Delete</a>
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
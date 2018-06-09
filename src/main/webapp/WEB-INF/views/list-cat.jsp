<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Categories</title>
</head>
<body class="bg-info" style="color: #dddddd"><div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <div style="padding:15px">
            <a class="btn btn-success" href="/category/add">Nouvelle Catégorie</a>
        </div>
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>userGroups</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
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
                        <td>
                            <a href="#groupsModal${category.id}" data-toggle="modal" data-target="#groupsModal${category.id}">see groups (${category.usersGroups.size()})</a>
                            <div class="modal fade" id="groupsModal${category.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">${category.categoryName} : groups</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="grpTable" style="width:90%">
                                                <thead>
                                                <tr>
                                                    <th>groupId</th>
                                                    <th>groupName</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="gr" items="${category.usersGroups}">
                                                    <tr>
                                                        <td>${gr.id}</td>
                                                        <td>${gr.userGroupName}</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td colspan="2">
                                                        <select>
                                                            <c:forEach var="ugrp" items="${allGroups}">
                                                                <option value="${ugrp.id}">${ugrp.userGroupName}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <a href="#" class="btn btn-info">add new group</a>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Groups</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <div style="padding:15px">
            <a class="btn btn-success" href="/group/add">Nouveau Group</a>
        </div>
        <table class="listTable">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Name</th>
                    <th>Members</th>
                    <th>Categories</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="group" items="${groups}" >
                    <%--Link for updates--%>
                    <c:url var="updateLink" value="/group/update" >
                        <c:param name="groupId" value="${group.id}" />
                    </c:url>

                    <%--Link for deletes--%>
                    <c:url var="deleteLink" value="/group/delete" >
                        <c:param name="groupId" value="${group.id}" />
                    </c:url>
                    <tr>
                        <td>${group.id}</td>
                        <td>${group.userGroupName}</td>
                        <td>
                            <a href="#memberModal${group.id}" data-toggle="modal" data-target="#memberModal${group.id}">see members (${group.users.size()})</a>
                            <div class="modal fade" id="memberModal${group.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">${group.userGroupName} : users</h5>
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
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="membre" items="${group.users}">
                                                        <tr>
                                                            <td>${membre.id}</td>
                                                            <td>${membre.email}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <td colspan="2">
                                                            <select>
                                                                <c:forEach var="user" items="${users}">
                                                                    <option value="${user.id}">${user.email}</option>
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
                        <td>
                            <a href="#catModal${group.id}" data-toggle="modal" data-target="#catModal${group.id}">see categories (${group.categories.size()})</a>
                            <div class="modal fade" id="catModal${group.id}" tabindex="-1" role="dialog"  aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">${group.userGroupName} : categories</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="catTable" style="width:90%">
                                                <thead>
                                                <tr>
                                                    <th>CatId</th>
                                                    <th>catName</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="cat" items="${group.categories}">
                                                    <tr>
                                                        <td>${cat.id}</td>
                                                        <td>${cat.categoryName}</td>
                                                    </tr>
                                                </c:forEach>
                                                <tr>
                                                    <td colspan="2">
                                                        <select>
                                                            <c:forEach var="categ" items="${categories}">
                                                                <option value="${categ.id}">${categ.categoryName}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <a href="#" class="btn btn-info">add new category</a>
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
                            <a href="${deleteLink}" class="btn btn-info" onclick="if(!(confirm('Are you sure to delete this group ?'))) return false" >Delete</a>
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
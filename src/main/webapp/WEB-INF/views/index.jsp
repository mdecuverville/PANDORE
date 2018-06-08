<%--
  Created by IntelliJ IDEA.
  User: jeremy benzakein
  Date: 06/05/2018
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <script type="text/javascript" src="/resources/scripts/index.js"></script>
    <link rel="stylesheet" href="/resources/css/index.css">
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">
    <div id="container">
        <div id="header">
            <%@include file="../../shared/header.jsp"%>
        </div>
        <div id="body">
            <table id="panneau">
                <thead class="bg-dark text-light">
                    <tr>
                        <th>Message</th>
                        <th>Emetteur</th>
                        <th>Date/heure</th>
                        <th>Likes</th>
                    </tr>
                </thead>
                <tbody class="text-black">
                    <c:forEach var="mes" items="${allMessages}">
                        <tr id="message${mes.id}">
                            <td>
                                <div><b>${mes.title}</b></div>
                                <div>${mes.content}</div>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${mes.anonymous}">
                                        anonyme
                                    </c:when>
                                    <c:otherwise>
                                        ${mes.createdBy.firstName} ${mes.createdBy.lastName}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                ${mes.createdAt}
                            </td>
                            <td class="text-center">
                                <div id="likecount${mes.id}">${mes.likes.size()}</div>
                                <div>
                                    <input type="hidden" class="messageId" value=" ${mes.id}">
                                    <button class="btn btn-dark likebtn" id="likebtn${mes.id}"><i class="far fa-thumbs-up fa-2x"></i></button>
                                </div>

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

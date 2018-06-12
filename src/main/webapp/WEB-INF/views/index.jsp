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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="home" value="/" scope="request" />


<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

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
                        <th>Id</th>
                        <th>Message</th>
                        <th>Emetteur</th>
                        <th>Date/heure</th>
                        <th>Likes</th>
                    </tr>
                </thead>
                <tbody class="text-black">
                    <c:forEach var="mes" items="${messagesAndlikes}">
                        <tr id="message${mes.key.id}">
                            <td>${mes.key.id}</td>
                            <td>
                                <div><b>${mes.key.title}</b></div>
                                <div>${mes.key.content}</div>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${mes.key.anonymous}">
                                        anonyme
                                    </c:when>
                                    <c:otherwise>
                                        ${mes.key.createdBy.firstName} ${mes.key.createdBy.lastName}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <fmt:formatDate type = "both" dateStyle="short" timeStyle="short" value = "${mes.key.createdAt}" />
                            </td>
                            <td class="text-center">
                                <div id="likecount${mes.key.id}">${mes.key.likes.size()}</div>
                                <div>
                                    <input type="hidden" class="messageId" value=" ${mes.key.id}">
                                    <c:set var="isLiked" value="${mes.value}" />
                                    <c:choose>
                                        <c:when test="${mes.value}">
                                            <button class="btn btn-dark likebtn liked" id="likebtn${mes.key.id}"><i class="far fa-thumbs-up fa-2x"></i></button>
                                        </c:when>
                                        <c:otherwise>
                                            <button class="btn btn-dark likebtn" id="likebtn${mes.key.id}"><i class="far fa-thumbs-up fa-2x"></i></button>
                                        </c:otherwise>
                                    </c:choose>

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

    <%--<script>--%>
        <%--$(document).ready(function($) {--%>

            <%--let likebtns = $(".likebtn");--%>
            <%--likebtns.click(function(){--%>
                <%--let mId = parseInt($(this).prev().val().replace(/\s/g,''));--%>
                <%--console.log("trying to like message "+mId);--%>
                <%--likeAjax(mId);--%>
            <%--});--%>

        <%--});--%>

        <%--function likeAjax(mId) {--%>

            <%--var data = {}--%>
            <%--data["id"] = mId;--%>

            <%--$.ajax({--%>
                <%--type : "POST",--%>
                <%--headers: {--%>
                    <%--'Accept': 'application/json',--%>
                    <%--'Content-Type': 'application/json'--%>
                <%--},--%>
                <%--url : "${home}test/test",--%>
                <%--data : JSON.stringify(data),--%>
                <%--dataType : 'json',--%>
                <%--timeout : 100000,--%>
                <%--success : function(data) {--%>
                    <%--console.log("SUCCESS: ", data);--%>
                    <%--display(data);--%>
                <%--},--%>
                <%--error : function(e) {--%>
                    <%--console.log("ERROR: ", e);--%>
                    <%--display(e);--%>
                <%--},--%>
                <%--done : function(e) {--%>
                    <%--console.log("DONE");--%>
                <%--}--%>
            <%--});--%>

        <%--}--%>


        <%--function display(data) {--%>
            <%--var json = "<h4>Ajax Response</h4><pre>"--%>
                <%--+ JSON.stringify(data, null, 4) + "</pre>";--%>
            <%--$('#feedback').html(json);--%>
        <%--}--%>
    <%--</script>--%>
</body>
</html>

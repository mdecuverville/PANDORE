<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/index.js"></script>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <jsp:include page="${pageContext.request.contextPath}/shared/header.jsp" flush="true" />
    </div>
    <div class="container bg-light">
        <div class="jumbotron" style="padding: 2rem;">

            <h1 class="text-dark">${conversation.conversationName}</h1>
            <p class="text-secondary">
                ${conversation.messages.get(0).content}
            </p>
            <hr>
            <h6 class="text-secondary">Date : ${conversation.createdAt}</h6>
            <%--<h6>Category : </h6>--%>
            <%--<h6>Etat de la demande : en cours</h6>--%>
        </div>
        <c:choose>
            <c:when test="${conversation.messages.size()>=2}">
                <div class="media media-space">
                    <div class="media-body">
                        <h4 class="media-heading text-dark">${conversation.messages.get(1).title}</h4>
                        <p class="text-secondary">
                            ${conversation.messages.get(1).content}
                        </p>
                        <hr>
                        <p class="text-secondary">Date : ${conversation.messages.get(1).createdAt}</p>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TEACHER', 'ROLE_ADMINISTRATION')">
                    <form method="post" action="/send/save/${conversation.id}">
                        <div class="form-group">
                            <input name="title" type="text" placeholder="Sujet..." class="form-control col-12 col-md-8" value="RE: ${conversation.conversationName}"/><br/>
                            <textarea class="form-control col-12 col-md-8" name="content" placeholder="Répondez au message..." rows="5" maxlength="400"></textarea>
                        </div>
                        <br>
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                        <button type="submit" class="btn btn-dark">Envoyer</button>
                    </form>
                </security:authorize>
            </c:otherwise>
        </c:choose>
        <br>
        <br>
        <br>
    </div>
    <div id="footer">
        <jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
    </div>
</div>
</body>
</html>

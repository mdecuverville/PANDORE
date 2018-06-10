<%@ page import="org.springframework.security.authentication.AnonymousAuthenticationToken" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %><%--
  Created by IntelliJ IDEA.
  User: benza
  Date: 06/05/2018
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%String url = (request.getRequestURL()).toString();%>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <%--logo--%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/logo_isep.svg" class="logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item <%=url.endsWith("/") ? "active" : ""%>">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Panneau d'Affichage</a>
            </li>
            <li class="nav-item <%=url.endsWith("/message/add") ? "active" : ""%>">
                <a class="nav-link" href="${pageContext.request.contextPath}/message/add">Nouveau message</a>
            </li>
            <%--<li class="nav-item <%=url.endsWith("messagerie.jsp") ? "active" : ""%>">--%>
                <%--<a class="nav-link" href="#">Messagerie</a>--%>
            <%--</li>--%>
            <li class="nav-item dropdown">

                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a class="nav-link dropdown-toggle <%=url.contains("/admin/") ? "active" : ""%>" href="#" id="dropdownAdmin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Admin
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/user/list">Users</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/category/list">Categories</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/group/list">UserGroups</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/message/list">Messages</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/conversation/list">Conversations</a>
                    </div>
                </security:authorize>

            </li>
        </ul>
        <%  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if(!(auth instanceof AnonymousAuthenticationToken)) { %>
        <div class="dropdown">
            <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <% out.print(auth.getName()); %> &nbsp; <i class="far fa-user-circle"></i>
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <div class="dropdown-item">
                    <form action="<%=request.getContextPath()%>/logout" method="POST">
                        <button type="submit" class="btn btn-danger">Logout</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </div>
        <% } else { %>
        <a href="${pageContext.request.contextPath}/showMyLoginPage" class="btn btn-primary">
            <span class="fas fa-sign-in-alt" aria-hidden="true"></span>
            Connexion
        </a>
        <% } %>
    </div>
</nav>
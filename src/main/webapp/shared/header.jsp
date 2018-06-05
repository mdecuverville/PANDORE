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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <%--logo--%>
    <a class="navbar-brand" href="index.jsp"><img src="resources/logo_isep.svg" class="logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Panneau d'Affichage <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Nouveau message</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Messagerie</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownAdmin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Admin
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Users</a>
                    <a class="dropdown-item" href="#">Categories</a>
                    <a class="dropdown-item" href="#">UserGroups</a>
                    <a class="dropdown-item" href="#">Messages</a>
                    <a class="dropdown-item" href="#">Conversations</a>
                </div>
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
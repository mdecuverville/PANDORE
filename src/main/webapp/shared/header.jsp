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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%String url = (request.getRequestURL()).toString();%>
<%Authentication auth = SecurityContextHolder.getContext().getAuthentication();%>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <%--logo--%>
    <a class="navbar-brand" href="/homepage"><img src="/resources/logo_isep.svg" class="logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item <%=url.endsWith("index.jsp") ? "active" : ""%>">
                <a class="nav-link" href="/homepage">Panneau d'Affichage</a>
            </li>
            <li class="nav-item <%=url.endsWith("formulaire.jsp") ? "active" : ""%>">
                <a class="nav-link" href="/formulaire.jsp">Nouveau message</a>
            </li>
            <li class="nav-item <%=url.endsWith("messagerie.jsp") ? "active" : ""%>">
                <a class="nav-link" href="#">Messagerie</a>
            </li>
            <% if (auth.isAuthenticated()){%>
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownAdmin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Admin
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/user/list">Users</a>
                            <a class="dropdown-item" href="/category/list">Categories</a>
                            <a class="dropdown-item" href="/group/list">UserGroups</a>
                            <a class="dropdown-item" href="/conversation/list">Conversations</a>
                            <a class="dropdown-item" href="/message/list">Messages</a>
                            <a class="dropdown-item" href="/like/list">Likes</a>
                        </div>
                    </li>
                </security:authorize>
            <%}%>
        </ul>

        <%if(!(auth instanceof AnonymousAuthenticationToken)) { %>
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

        <%--<form action="${pageContext.request.contextPath}/showMyLoginPage" method="get">--%>
            <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="loginModal">--%>
                <%--<span class="fas fa-sign-in-alt" aria-hidden="true"></span>--%>
                <%--Connexion--%>
            <%--</button>--%>
        <%--</form>--%>
        <%--<div class="modal fade" id="loginModal" tabindex="-1" data-controls-modal="your_div_id" data-backdrop="static" data-keyboard="false" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
            <%--<div class="modal-dialog" role="document">--%>
                <%--<div class="modal-content">--%>
                    <%--<div class="modal-header">--%>
                        <%--<h5 class="modal-title">Connexion</h5>--%>
                        <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                            <%--<span aria-hidden="true">&times;</span>--%>
                        <%--</button>--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<form action="" method="post">--%>
                            <%--<label for="email" class="col-4">E-mail :</label><input type="text" id="email" name="email" class="col-8"/> <br />--%>
                            <%--<label for="password" class="col-4">Mot de passe :</label><input type="password" id="password" name="password" class="col-8"/> <br /> <br />--%>
                            <%--<button type="submit" class="btn btn-primary col-8 offset-2 offset-md-0 col-md-4 float-md-right">Se connecter</button>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <a href="${pageContext.request.contextPath}/showMyLoginPage" class="btn btn-primary">
            <span class="fas fa-sign-in-alt" aria-hidden="true"></span>
            Connexion
        </a>
        <% } %>
    </div>
</nav>
<%--
  Created by IntelliJ IDEA.
  User: jeremy benzakein
  Date: 06/05/2018
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="shared/resources.jsp"%>
    <script type="text/javascript" src="../scripts/index.js"></script>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="shared/header.jsp"%>
    </div>
    <div id="body">
        <h2 class="pagetitle">Panneau d'affichage</h2>

        <select class="custom-select col-12 col-md-3">
            <option selected disabled>Catégories</option>
            <option>Enseignement</option>
            <option>Parcours de Formation</option>
            <option>Matériel d'entretien/Salle</option>
            <option>Autres</option>
        </select>


        <span class="filtre"><span class="fas fa-filter"></span>&nbsp;<input type="text" placeholder="Filtre..."/></span>

        <p>Ici se situera le tableau du panneau d'affichage</p>

        <%--<security:authorize access="isAuthenticated()">
            user : <security:authentication property="principal.username" />
            role : <security:authentication property="principal.authorities" />
        </security:authorize>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer porta enim tincidunt, ultricies magna id, ullamcorper eros. Phasellus vitae libero rutrum nibh fermentum cursus a lobortis ante. Pellentesque accumsan, diam sit amet imperdiet tempus, lorem risus fringilla ex, eget tempor justo ligula a diam. Quisque at mi purus. Integer mattis bibendum purus et feugiat. Mauris a ante bibendum, ullamcorper diam ut, consequat ante. Etiam sagittis id purus aliquam auctor.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer porta enim tincidunt, ultricies magna id, ullamcorper eros. Phasellus vitae libero rutrum nibh fermentum cursus a lobortis ante. Pellentesque accumsan, diam sit amet imperdiet tempus, lorem risus fringilla ex, eget tempor justo ligula a diam. Quisque at mi purus. Integer mattis bibendum purus et feugiat. Mauris a ante bibendum, ullamcorper diam ut, consequat ante. Etiam sagittis id purus aliquam auctor.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer porta enim tincidunt, ultricies magna id, ullamcorper eros. Phasellus vitae libero rutrum nibh fermentum cursus a lobortis ante. Pellentesque accumsan, diam sit amet imperdiet tempus, lorem risus fringilla ex, eget tempor justo ligula a diam. Quisque at mi purus. Integer mattis bibendum purus et feugiat. Mauris a ante bibendum, ullamcorper diam ut, consequat ante. Etiam sagittis id purus aliquam auctor.</p>

        <security:authorize access="hasRole('ADMIN')">
            <p>I AM AN ADMIN</p>
        </security:authorize>

        <security:authorize access="hasRole('TEACHER')">
            <p>I AM AN TEACHER</p>
        </security:authorize>

        <security:authorize access="hasRole('STUDENT')">
            <p>I AM AN STUDENT</p>
        </security:authorize>

        <security:authorize access="hasRole('ADMINISTRATOR')">
            <p>I AM AN ADMINISTRATOR</p>
        </security:authorize>--%>

    </div>
    <div id="footer">
        <%@include file="shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

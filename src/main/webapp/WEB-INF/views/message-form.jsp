<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <div id="body">

        <h2 class="pagetitle">Nouveau Message</h2>

        <form method="post" action="/send/save">
            <div class="form-group">
                <select class="custom-select col-12 col-md-3" id="categorieselect" name="categoryId">
                    <option value="" selected disabled>Catégories</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="input-group form-group">
                <span><input id="private" name="privacy" type="checkbox"/><label for="private">&nbsp;Privé</label>&nbsp;<span class="fas fa-info-circle"
                                                                                                                              id="infos" data-toggle="tooltip" data-placement="right" title="Ce paramètre est public par défaut"></span></span>
            </div>

            <div class="input-group form-group">
                <span><input type="checkbox" id="anonyme" name="anonymism"/><label for="anonyme">&nbsp;Je souhaite être anonyme</label></span>
            </div>

            <div class="form-group">
                <input name="title" type="text" placeholder="Sujet..." class="form-control col-12 col-md-8"/><br/>
                <textarea name="content" placeholder="Ici, vous pouvez écrire votre message" class="form-control col-12 col-md-8" rows="5"></textarea>
            </div>

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            <button type="submit" class="btn btn-dark">Envoyer</button>

        </form>

    </div>

    <div id="footer">
        <jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
    </div>
</div>
</body>

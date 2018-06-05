<%--
  Created by IntelliJ IDEA.
  User: Anne
  Date: 22/05/2018
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <script type="text/javascript" src="resources/scripts/formulaire.js"></script>
    <title>Formulaire</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">

        <h2 class="pagetitle">Nouveau Message</h2>

        <form method="post" action="/message/save">
            <div class="form-group">
                <select class="custom-select col-12 col-md-3" id="categorieselect">
                    <option value="" selected disabled>Catégories</option>
                    <option>Enseignement</option>
                    <option>Parcours de Formation</option>
                    <option>Matériel d'entretien/Salle</option>
                    <option>Autres</option>
                </select>
            </div>

            <div class="input-group form-group">
                <span><input id="private" type="checkbox"/><label for="private">&nbsp;Privé</label>&nbsp;<span class="fas fa-info-circle"
                                                                                                               id="infos" data-toggle="tooltip" data-placement="right" title="Ce paramètre est public par défaut"></span></span>
            </div>

            <div class="input-group form-group">
                <span><input type="checkbox" id="anonyme" name="isAnonymous"/><label for="anonyme">&nbsp;Je souhaite être anonyme</label></span>
            </div>

            <div class="form-group">
                <input name="title" type="text" placeholder="Sujet..." class="form-control col-12 col-md-8"/><br/>
                <textarea name="content" placeholder="Ici, vous pouvez écrire votre message" class="form-control col-12 col-md-8" rows="5"></textarea>
            </div>

            <button type="submit" class="btn btn-dark">Envoyer</button>

        </form>

    </div>

    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

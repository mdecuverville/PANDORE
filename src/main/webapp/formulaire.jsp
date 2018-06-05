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
    <%@include file="shared/resources.jsp"%>
    <script type="text/javascript" src="scripts/index.js"></script>
    <title>Formulaire</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="shared/header.jsp"%>
    </div>
    <div id="body">

        <h2 class="pagetitle">Nouveau Message</h2>

        <div>
            <select class="formcategoryselect">
                <option selected disabled>Catégories</option>
                <option>Enseignement</option>
                <option>Parcours de Formation</option>
                <option>Matériel d'entretien/Salle</option>
                <option>Autres</option>
            </select>
        </div>

        <div>
            <br/>
            <span><label><input type="checkbox"/>Privé</label>&nbsp;<span class="fas fa-info-circle" id="infos" title="Ce paramètre est public par défaut"></span></span>
            <br/>
            <label><input type="checkbox"/>Je souhaite être anonyme</label>
        </div>

        <div>
            <input type="text" placeholder="Sujet..."/><br/>
            <textarea placeholder="Ici, vous pouvez écrire votre message" class="messageform"></textarea>
        </div>

        <div>
            <button type="submit">Envoyer</button>
        </div>

    </div>
    <div id="footer">
        <%@include file="shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

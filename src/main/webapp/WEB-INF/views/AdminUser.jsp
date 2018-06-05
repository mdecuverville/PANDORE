<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>Panneau d'affichage</title>
</head>
<body class="bg-info" style="color: #dddddd">

<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <table class="fulltable fulltable-editable" id="test-table">
            <thead>
            <tr>
                <th fulltable-field-name="firstname">First name</th>

                <th fulltable-field-name="lastname">Last name</th>

                <th fulltable-field-name="Password_hash">Password hash</th>

                <th fulltable-field-name="email">Email</th>

            </tr>

            </thead>

            <tbody>

            <tr>
                <td><span>John</span></td>
                <td><span>Smith</span></td>
                <td><span>azerty</span></td>
                <td><span>email1</span></td>

            </tr>

            <tr>
                <td><span>Peter</span></td>
                <td><span>Pan</span></td>
                <td><span>azerty</span></td>
                <td><span>email2</span></td>
            </tr>
            <tr>
                <td><span>Mary</span></td>
                <td><span>Stevenson</span></td>
                <td><span>azerty</span></td>
                <td><span>email3</span></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>

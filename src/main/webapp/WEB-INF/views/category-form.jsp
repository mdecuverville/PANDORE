<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@include file="../../shared/resources.jsp"%>
    <title>add category</title>
</head>
<body class="bg-info" style="color: #dddddd">
<div id="container">
    <div id="header">
        <%@include file="../../shared/header.jsp"%>
    </div>
    <div id="body">
        <div >
            <h3>Save category</h3>
            <form:form action="save" modelAttribute="category" method="post" >
                <table class="table">
                    <tbody>
                    <form:hidden path="id" />
                    <tr>
                        <td><label for="name">Category Name :</label></td>
                        <td><form:input name="name" path="categoryName"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" /></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>

            <div style="clear: both"></div>

            <p>
                <a href="${pageContext.request.contextPath}/group/list">Back to list</a>
            </p>

        </div>
    </div>
    <div id="footer">
        <%@include file="../../shared/footer.jsp"%>
    </div>
</div>
</body>
</html>
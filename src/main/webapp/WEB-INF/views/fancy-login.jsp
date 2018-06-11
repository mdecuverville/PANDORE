<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/in"></script>
	<title>Login Page</title>
</head>
<body class="my-login-page">
<section class="h-100">
	<div class="container h-100">
		<div class="row justify-content-md-center h-100">
			<div class="card-wrapper">
				<div class="card fat">
					<div class="card-body">
						<h4 class="card-title">Sign In</h4>
						<!-- Login Form -->
						<form action="${pageContext.request.contextPath}/authenticateTheUser"
							  method="POST" >
							<!-- Check for login error -->

							<c:if test="${param.error != null}">

								<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									Invalid email and password.
								</div>

							</c:if>

							<!-- Check for logout -->

							<c:if test="${param.logout != null}">

								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.
								</div>

							</c:if>
							<div class="form-group">
								<label for="email">E-Mail Address</label>
								<input id="email" type="email" class="form-control" name="username" value="" required autofocus>
								<br>
								<input id="password" type="password" class="form-control" name="password" required data-eye>
							</div>

							<div class="form-group no-margin">
								<button type="submit" class="btn btn-secondary btn-block">
									Login
								</button>
							</div>

							<input type="hidden"
								   name="${_csrf.parameterName}"
								   value="${_csrf.token}" />
						</form>
					</div>
				</div>
				<div class="footer">
					Copyright &copy; ISEPBox 2018
				</div>
			</div>
		</div>
	</div>
</section>
<div id="footer">
	<jsp:include page="${pageContext.request.contextPath}/shared/resources.jsp" flush="true" />
</div>
</div>
</body>
</html>

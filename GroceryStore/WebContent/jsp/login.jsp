<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Please Log-In to Continue</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login.do" method="post">
		Please login here:<br>
		Email Address
		<input type="text" name="email"><br>
		Password
		<input type="password" name="password"><br><br>
		
		<input type="submit" value="Log In"><br>
	</form>	
	
	<form action="${pageContext.request.contextPath}/wecare.do" method="post">
	<input type="submit" value="Sign Up">
	</form>


</body>
</html>
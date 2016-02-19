<%@ page import = "java.util.*" import = "com.project.pojo.Food" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>We Care!</title>
</head>
<body>
<jsp:include page="header.jsp" /><br>

	Browse our goods!
	<form action= /GroceryStore/wecare.do method="post" name=inputForm>	
	<input type="hidden" name="action" value="catalog">
	<input type="submit" value="Browse">
	</form>
	
	<form action= /GroceryStore/wecare.do method="post" name=inputForm>	
	<input type="hidden" name="action" value="cart">
	<input type="submit" value="Proceed to Shopping Cart">
	</form>
	
<br><jsp:include page="footer.jsp" />
</body>
</html>
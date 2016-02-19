<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<form action="demo_form.asp" method="get">

 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/cart.jsp">Shopping Cart</button>     
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/index.jsp">Home</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/login.jsp">Login</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
</form>


</body>
</html>
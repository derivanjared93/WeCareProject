<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<form>

 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/cart.jsp">Shopping Cart</button>     
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/index.jsp">Home</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/login.jsp">Login</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
 <button type="submit" formaction="${pageContext.request.contextPath}/jsp/checkout.jsp">Checkout</button>
</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<jsp:include page="header.jsp" /> 

<table border="1">
	<tr>
	<th>Picture</th>
	<th>Name</th>
	<th>Price</th>
	<th>Quantity</th>
	</tr>
	
	<!-- Going to receive the current customer's information, and then loop through a for loop, printing out every item in their currentOrder variable -->
	<tr><td>Image not Found</td><td>Beef Jerky</td><td>2.99</td><td>5</td></tr>
	<tr><td>Image not Found</td><td>Apples</td><td>.99</td><td>3</td></tr>
	<tr><td>Image not Found</td><td>Rice Krispies</td><td>1.99</td><td>6</td></tr>
	<tr><td>Image not Found</td><td>Bananas</td><td>.45</td><td>20</td></tr>
	<tr><td>Image not Found</td><td>Candy</td><td>.99</td><td>1</td></tr>
	<tr><td>Image not Found</td><td>Canadian Bacon</td><td>9.99</td><td>2</td></tr>
</table>
<br>
<br>

<form action= /GroceryStore/wecare.do method="post" name=inputForm>
Subtotal: $2,000.00 <br>
Savings: $1,995.00<br>
Total:  $5.00<br>

<input type="hidden" name="action" value="checkout">
<input type="submit" value="Proceed to Checkout">
</form>


<jsp:include page="footer.jsp" /> 
</body>
</html>
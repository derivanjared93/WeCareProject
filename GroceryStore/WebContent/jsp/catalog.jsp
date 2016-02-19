<%@ page import = "java.util.*" import = "com.project.pojo.Food" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp" /><br>

	Browse our goods!

	<table border="1">
	<tr>
	<% 
		List<Food> foodList = (List<Food>)request.getAttribute("list_food");
		for(Food f : foodList)
		{
			out.println("<td>" + f.getFoodID() 		+ "</td>");
			out.println("<td>" + f.getFoodName()  	+ "</td>");
			out.println("<td>" + f.getFoodPrice()	+ "</td>");
			out.println("<td>" + f.getFoodCategory()+ "</td>");
			out.println("<td>" + f.getFoodBrand() 	+ "</td>");
			//out.println("<td><a href=\"./employee.do?action=update_emp_view&emp_id=" + emp.getEmpID() + "\">Update</a></td>");
			//out.println("<td><a href=\"./employee.do?action=group_by_emp&emp_id=" + emp.getEmpID()+"\">View Groups</a></td>");
			//out.println("<td><a href=\"#\" onclick=\"deleteConfirm('" + emp.getEmpID()+ "')\">Delete</a></td>");
		}
	%>
	</tr>
	</table>
	
<br><jsp:include page="footer.jsp" />
</body>
</html>
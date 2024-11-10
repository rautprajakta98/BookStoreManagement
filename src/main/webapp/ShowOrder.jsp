<%@page import="com.onlinebookstore.model.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="SideBar.jsp"></jsp:include>
<% List<Order> orders = (List<Order>) request.getAttribute("allOrder");
double total=0;
%>

	<table border="2" align="center">
	
		<tr>
			<td>Order Status</td>
			<td>Book Name</td>
			<td>Book Quantity</td>
			<td>totalBill</td>
			<td>User EmailId</td>
		</tr>

		<%
		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			total=total+order.getTotalBill();
		%>
		<tr>
			<td><%=order.getOrderStatus()%></td>
			<td><%=order.getBookName()%></td>
			<td><%=order.getQuantity()%></td>
			<td><%=order.getTotalBill()%></td>
			<td><%=order.getUserEmailId()%></td>
				</tr>
		<%
		}
		%>
      

	</table>
	<br><br>
	<p align="right" style="font-size: 15px">Your Total Bill is:<%=total %></p>
<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
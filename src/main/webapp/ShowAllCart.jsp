<%@page import="com.onlinebookstore.model.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var bookQuantity = document.getElementById("bookQuantity").value;

		if(!/^[0-9]+$/.test(bookQuantity)){
		    alert("Please only enter numeric characters only for your Age! (Allowed input:0-9)");
			return false;
		  }
		return true;
	}
</script>
</head>
<body>
	<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="SideBar.jsp"></jsp:include>
	<%
	List<Cart> carts = (List<Cart>) request.getAttribute("allCart");
	%>
	<form action="OrderController" method="post" 
	onsubmit="return validate()">
	<table border="2">
		<tr>
			<td>Book Name</td>
			<td>Book Price</td>
			<td>Quantity</td>
			<td>Action</td>
		</tr>

		<%
		String bookNames = null;
		String bookPrices = null;
		for (int i = 0; i < carts.size(); i++) {
			Cart cart = carts.get(i);
			bookNames = bookNames + "," + cart.getBookName();
			bookPrices = bookPrices + "," + cart.getBookPrice();
		%>
		<tr>
			<td><%=cart.getBookName()%></td>
			<td><%=cart.getBookPrice()%></td>
			<%-- <td><%=cart.getQuantity()%></td> --%>
			<td> <input type="text" name="bookQuantity" id="bookQuantity"> </td>
			<td><a
				href="CartController?frompage=deleteCart&cartId=
				<%=cart.getCartId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
		

		<input type="hidden" name="frompage" value="fromCart">
		<input type="hidden" name="bookNames" value="<%=bookNames%>">
		<input type="hidden" name="bookPrices" value="<%=bookPrices%>">
	<input type="submit">
	</form>
		<jsp:include page="Footer.jsp"></jsp:include>
		</div>
</body>
</html>
<%@page import="com.onlinebookstore.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
p{
font-family: ariel;
align: center;
font-size: 15px;
}
</style>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="SideBar.jsp"></jsp:include>
		<%
		Book book = (Book) (request.getAttribute("viewSinglebook"));
		%>
		
			<div style="float:left;width:40%">
			<img src="images/<%=book.getBookImg()%>"
				style="height: 250px; width: 200px" />
			</div>
			
			<div style="float:right;width:60%"></div>
			
			<b>BookName : </b><%=book.getBookName()%><br><br>
			<b>Author : </b><%=book.getBookAuthor()%><br><br>
			<b>Price : </b><%=book.getBookPrice()%><br><br>
			<b>Publisher :</b> <%=book.getBookPublisher()%><br><br>
			<b>Quantity : </b><%=book.getBookQuantity()%><br><br>
			<b>Category : </b><%=book.getBookCategory()%><br><br>
			<b> Description : </b><%=book.getBookDesc()%><br><br>
			
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
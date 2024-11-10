<%@page import="com.onlinebookstore.model.Book"%>
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
	<%
	List<Book> books = (List<Book>) request.getAttribute("allBook");
	%>

	<table border="2" align="center">
		<tr>
			<td>Book Name</td>
			<td>Book Author</td>
			<td>Book Price</td>
			<td>Book Publisher</td>
			<td>Book Quantity</td>
			<td>Book Category</td>
			<td>Book Image</td>
			<td>Book Description</td>
			<td>Action Update</td>
			<td>Action Delete</td>
		</tr>

		<%
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
		%>
		<tr>
			<td><%=book.getBookName()%></td>
			<td><%=book.getBookAuthor()%></td>
			<td><%=book.getBookPrice()%></td>
			<td><%=book.getBookPublisher()%></td>
			<td><%=book.getBookQuantity()%></td>
			<td><%=book.getBookCategory()%></td>
			<td><img id="<%=book.getBookId()%>"
				src="images/<%=book.getBookImg()%>" height=40px width=40px></td>

			<td><%=book.getBookDesc()%></td>
			<td><a
				href="BookController?fromPage=updateBook&bookId=<%=book.getBookId()%>">Update</a></td>
			<td><a
				href="BookController?fromPage=deleteBook&bookId=<%=book.getBookId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>


	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
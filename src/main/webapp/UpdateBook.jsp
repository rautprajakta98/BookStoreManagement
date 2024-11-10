<%@page import="com.onlinebookstore.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var bookName = document.getElementById("ibookName").value;
		var bookAuthor = document.getElementById("ibookAuthor").value;
		var bookPrice = document.getElementById("ibookPrice").value;
		var bookPublisher = document.getElementById("ibookPublisher").value;
		var bookQuantity = document.getElementById("ibookQuantity").value;
		var bookCategory = document.getElementById("ibookCategory").value;
		var bookDescription = document.getElementById("ibookDescription").value;

		if (bookName == null || bookName == "") {
			document.getElementById("sbookName").innerText = "Enter Book Name";
			return false;
		}
		if (bookAuthor == null || bookAuthor == "") {
			document.getElementById("sbookAuthor").innerText = "Enter Author Name";
			return false;
		}
		if (bookPrice == null || bookPrice == "") {
			document.getElementById("sbookPrice").innerText = "Enter Book Price";
			return false;
		}
		if (bookPublisher == null || bookPublisher == "") {
			document.getElementById("sbookPublisher").innerText = "Enter Publisher Name";
			return false;
		}
		if (bookQuantity == null || bookQuantity == "") {
			document.getElementById("sbookQuantity").innerText = "Enter Book Quantity";
			return false;
		}
		if (bookCategory == null || bookCategory == "") {
			document.getElementById("sbookCategory").innerText = "Enter Book Category";
			return false;
		}
		if (bookDescription == null || bookDescription == "") {
			document.getElementById("sbookDescription").innerText = "Enter Book Description";
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
	Book book = (Book) request.getAttribute("singleBook");
	%>

	<form action="BookController" method="post"
		onsubmit="return validate()">

		<input type="hidden" name="fromPage" value="updateBook"> <input
			type="hidden" name="bookId" value="<%=book.getBookId()%>">

		<table>
			<tr>
				<td>Book Name</td>
				<td><input type="text" name="bookName" id="ibookName"
					class="cbookName" value="<%=book.getBookName()%>"></td>
				<td><span id="sbookName">*</span></td>
			</tr>

			<tr>
				<td>Book Author</td>
				<td><input type="text" name="bookAuthor" id="ibookAuthor"
					class="cbookAuthor" value="<%=book.getBookAuthor()%>"></td>
				<td><span id="sbookAuthor">*</span></td>
			</tr>

			<tr>
				<td>Book Price</td>
				<td><input type="text" name="bookPrice" id="ibookPrice"
					class="cbookPrice" value="<%=book.getBookPrice()%>"></td>
				<td><span id="sbookPrice">*</span></td>
			</tr>

			<tr>
				<td>Book Publisher</td>
				<td><input type="text" name="bookPublisher" id="ibookPublisher"
					class="cbookPublisher" value="<%=book.getBookPublisher()%>"></td>
				<td><span id="sbookPublisher">*</span></td>

			</tr>

			<tr>
				<td>Book Quantity</td>
				<td><input type="text" name="bookQuantity" id="ibookQuantity"
					class="cbookQuantity" value="<%=book.getBookQuantity()%>"></td>
				<td><span id="sbookQuantity">*</span></td>

			</tr>

			<tr>
				<td>Book Category</td>
				<td><input type="text" name="bookCategory" id="ibookCategory"
					class="cbookCategory" value="<%=book.getBookCategory()%>"></td>
				<td><span id="sbookCategory">*</span></td>

			</tr>

			<tr>
				<td>Book Description</td>
				<td><input type="text" name="bookDescription"
					id="ibookDescription" class="cbookDescription"
					value="<%=book.getBookDesc()%>"></td>
				<td><span id="sbookDescription">*</span></td>

			</tr>

			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>

	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
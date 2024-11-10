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
		var bookPrice = document.getElementById("ibookPrice").value;
		var bookQuantity = document.getElementById("ibookQuantity").value;
		var bookId = document.getElementById("ibookId").value;
		var userEmailId = document.getElementById("iuserEmailId").value;

		if (bookName == null || bookName == "") {
			document.getElementById("sbookName").innerText = "Enter Book Name";
			return false;
		}
		
		if (bookPrice == null || bookPrice == "") {
			document.getElementById("sbookPrice").innerText = "Enter Book Price";
			return false;
		}
		
		if (bookQuantity == null || bookQuantity == "") {
			document.getElementById("sbookQuantity").innerText = "Enter Book Quantity";
			return false;
		}
		if (bookId == null || bookId == "") {
			document.getElementById("sbookId").innerText = "Enter Book Id";
			return false;
		}
		if (userEmailId == null || userEmailId == "") {
			document.getElementById("suserEmailId").innerText = "Enter User EmailId";
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h1>Add Cart</h1>
	<form action="CartController" method="post" onsubmit="return validate()">
		<input type="hidden" name="fromPage" value="addbook" />
		<table>
			<tr>
			    <td>Book Name</td>
				<td><input type="text" name="bookName" id="ibookName"
					class="cbookName"></td>
				<td><span id="sbookName">*</span></td>
			</tr>
			<tr>
			    <td>Book Price</td>
				<td><input type="text" name="bookPrice" id="ibookPrice"
					class="cbookPrice"></td>
				<td><span id="sbookPrice">*</span></td>
			</tr>
			<tr>
			   <td>Book Quantity</td>
				<td><input type="text" name="bookQuantity" id="ibookQuantity"
					class="cbookQuantity"></td>
				<td><span id="sbookQuantity">*</span></td>
			</tr>
			<tr>
			   <td>Book Id</td>
				<td><input type="text" name="bookId" id="ibookId"
					class="cbookId"></td>
				<td><span id="sbookId">*</span></td>

			</tr>
			<tr>
			   <td>User EmailId</td>
				<td><input type="text" name="userEmailId" id="iuserEmailId"
					class="cuserEmailId"></td>
				<td><span id="suserEmailId">*</span></td>
			</tr>
             <tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>


		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	<!--  ********************Pending code-->
</body>
</html>
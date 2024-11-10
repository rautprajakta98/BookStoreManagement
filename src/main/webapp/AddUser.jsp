<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="PasswordStrengthChecker.css">
<script type="text/javascript" src="jquery-3.7.1.js"></script>
<script type="text/javascript" src="PasswordStrengthChecker.js"></script>
<script type="text/javascript">
	function validate() {

		var userName = document.getElementById("iuserName").value;
		var userAddress = document.getElementById("iuserAddress").value;
		var userEmail = document.getElementById("iuserEmail").value;
		var userContact = document.getElementById("iuserContact").value;
		var userPassword = document.getElementById("iuserPassword").value;

		var isError = false;

		if (userName == null || userName == "") {
			document.getElementById("suserName").innerText = "Enter User Name";
			isError = true;
		}
		if (userAddress == null || userAddress == "") {
			document.getElementById("suserAddress").innerText = "Enter User Address";
			isError = true;
		}
		if (userEmail == null || userEmail == "") {
			document.getElementById("suserEmail").innerText = "Enter User Email-ID";
			isError = true;
		}
		if (userContact == null || userContact == "") {
			document.getElementById("suserContact").innerText = "Enter User Contact-NO";
			isError = true;
		}
		if (userPassword == null || userPassword == "") {
			document.getElementById("suserPassword").innerText = "Enter User Password";
			isError = true;
		}

		if (isError) {
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
	<h1 align="center">Add User</h1>

	<form action="UsersController" method="post" onsubmit="return validate()">
	<input type="hidden" name="fromPage" value="addUser">
		<table align="center">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" id="iuserName"
					class="cuserName"></td>
				<td><span id="suserName">*</span></td>

			</tr>

			<tr>
				<td>User Address</td>
				<td><input type="text" name="userAddress" id="iuserAddress"
					class="cuserAddress"></td>
				<td><span id="suserAddress">*</span></td>

			</tr>

			<tr>
				<td>User Email-ID</td>
				<td><input type="text" name="userEmail" id="iuserEmail"
					class="cuserEmail"></td>
				<td><span id="suserEmail">*</span></td>

			</tr>

			<tr>
				<td>User Contact-No</td>
				<td><input type="text" name="userContact" id="iuserContact"
					class="cuserContact"></td>
				<td><span id="suserContact">*</span></td>

			</tr>

			<tr>
				<td>User Password</td>
				<td><input type="text" name="userPassword" id="iuserPassword"
					class="cuserPassword"></td>
				<td><span id="suserPassword">*</span></td>

			</tr>

			<tr>
				<td>Is Admin</td>
				<td><input type="checkbox" name="isAdmin" id="iisAdmin"
					class="cisAdmin"></td>
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
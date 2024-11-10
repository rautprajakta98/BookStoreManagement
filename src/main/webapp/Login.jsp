<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var userName = document.getElementById("iuserName").value;
		var userPassword = document.getElementById("iuserPassword").value;

		if (userName == null || userName == "") {
			document.getElementById("suserName").innerText = "Enter User Name";
			return false;
		} else if (userPassword == null || userPassword == "") {
			document.getElementById("suserPassword").innerText = "Enter User Password";
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

	<h1>Login Page</h1>

	<form action="LoginController" method="post"
		onsubmit="return validate()">
		<input type="hidden" name="frompage" value="login">
		<table>
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="userName" id="iuserName"
					class="cuserName"></td>
				<td><span id="suserName">*</span></td>

			</tr>

			<tr>
				<td>Enter User Password</td>
				<td><input type="text" name="userPassword" id="iuserPassword"
					class="cuserPassword"></td>
				<td><span id="suserPassword">*</span></td>

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
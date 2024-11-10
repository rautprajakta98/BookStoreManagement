<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate() {
		var oldPassword = document.getElementById("ioldPassword").value;
		var newPassword = document.getElementById("inewPassword").value;

		if (oldPassword == null || oldPassword == "") {
			document.getElementById("soldPassword").innerText = "Enter Old Password";
			return false;
		} else if (newPassword == null || newPassword == "") {
			document.getElementById("snewPassword").innerText = "Enter New Password";
			return false;
		}

		return true;
	}
</script>
</head>
<body>
<div id="templatemo_container" align="center">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="SideBar.jsp"></jsp:include>
	<h1>Reset Password</h1>

	<form action="LoginController" method="post" onsubmit="return validate()">
	<input type="hidden" name="frompage" value="resetpassword">
		<table>
			<tr>
				<td>Enter Old Password</td>
				<td><input type="text" name="oldPassword" id="ioldPassword"
					class="coldPassword"></td>
				<td><span id="soldPassword">*</span></td>

			</tr>

			<tr>
				<td>Enter New Password</td>
				<td><input type="text" name="newPassword" id="inewPassword"
					class="cnewPassword"></td>
				<td><span id="snewPassword">*</span></td>

			</tr>

			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
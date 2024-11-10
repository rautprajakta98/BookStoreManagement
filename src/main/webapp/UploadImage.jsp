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
	<form action="UploadImageController" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select Image</td>
				<td><input type="file" name="multiPartServlet"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
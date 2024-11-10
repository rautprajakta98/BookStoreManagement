<%@page import="com.onlinebookstore.model.Users"%>
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
	List<Users> users = (List<Users>) request.getAttribute("allUser");
	%>

	<!-- private String userName;
	private String userAddress;
	private String userEmailId;
	private String userContactNo;
	private String userPassword;
	private boolean isAdmin; -->
	<table border="2" align="center">
		<tr>
			<td>User Name</td>
			<td>User Address</td>
			<td>User Email</td>
			<td>User Contact</td>
			<td>User Password</td>
			<td>User isAdmin</td>
			<td>Action Update</td>
			<td>Action Delete</td>
		</tr>

		<%
		for (int i = 0; i < users.size(); i++) {
			Users user = users.get(i);
		%>

		<tr>
			<td><%=user.getUserName()%></td>
			<td><%=user.getUserAddress()%></td>
			<td><%=user.getUserEmailId()%></td>
			<td><%=user.getUserContactNo()%></td>
			<td><%=user.getUserPassword()%></td>
			<td><%=user.isAdmin()%></td>
			<td><a
				href="UsersController?fromPage=updateUser&userId=
				<%=user.getUserId()%>">Update</a></td>
			<td><a
				href="UsersController?fromPage=deleteUser&userId=
				<%=user.getUserId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
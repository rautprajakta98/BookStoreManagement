<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container" align="center">
<jsp:include page="Header.jsp"></jsp:include>
<%
String error = (String) request.getAttribute("invalidDetails");

if(error.equalsIgnoreCase("invalidDetails")){
%>
<h1 style="color: red;">Please Enter Valid Details(Check Your I'd And Password) </h1> <br><br>

<h3><a href="Login.jsp">Back</a></h3><br>
<%
}
%>

<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>
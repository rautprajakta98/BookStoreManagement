<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

h1,h2{
color:orange;
}
p.p1{

color:violet;
}
</style>
</head>
<body>
<div id="templatemo_container" align="center">
	<jsp:include page="Header.jsp"></jsp:include>
	
	<div class="container">
		<header>
			<h1 style="">Contact Us</h1>
			<p class="p1">We're happy to help! Feel free to reach out using the
				information below.</p>
		</header>
		
		<section class="contact-info">
			<h2>Contact Information</h2>
			<p class="p1">
				<b>Phone:</b> 9856234586
			</p>
			<p class="p1">
				<b>Address:</b> Thane-401102
			</p>
			<p class="p1">
				<b>Email:</b> prajaraut74@gmail.com
			</p>
		</section>

	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>
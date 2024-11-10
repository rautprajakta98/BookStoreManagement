<%@page import="com.onlinebookstore.model.Category"%>
<%@page import="com.onlinebookstore.model.Publisher"%>
<%@page import="java.util.List"%>
<%@page import="com.onlinebookstore.utility.ObjectsUtility"%>
<%@page import="com.onlinebookstore.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords"
	content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description"
	content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<%
	BookService bookService = ObjectsUtility.getBookService();
	List<Publisher> publishers = bookService.getAllPublisher();

	List<Category> categories = bookService.getAllCategory();
	%>
	<div id="templatemo_container">

		<div id="templatemo_content">

			<div id="templatemo_content_left">
				<div class="templatemo_content_left_section">
					<h1>Categories</h1>
					<ul>
						<%
						for (int i = 0; i < categories.size(); i++) {
							Category category = categories.get(i);
						%>
						<li><a
							href="BookController?fromPage=searchCategory&category=<%=category.getCategoryName()%>"><%=category.getCategoryName()%></a></li>
						<%
						}
						%>
					</ul>
				</div>
				<div class="templatemo_content_left_section">
					<h1>Publisher</h1>
					<ul>
						<%
						for (int i = 0; i < publishers.size(); i++) {
							Publisher publisher = publishers.get(i);
						%>
						<li><a
							href="BookController?fromPage=searchPublisher&publisher=<%=publisher.getPublisherName()%>"><%=publisher.getPublisherName()%></a>
						</li>
						<%
						}
						%>
					</ul>
				</div>

				

				 <div class="templatemo_content_left_section">
					<a href="http://validator.w3.org/check?uri=referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://www.w3.org/Icons/valid-xhtml10"
						alt="Valid XHTML 1.0 Transitional" width="88" height="31"
						vspace="8" border="0" /></a> <a
						href="http://jigsaw.w3.org/css-validator/check/referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
						alt="Valid CSS!" vspace="8" border="0" /></a>
				</div> 
			</div>
			<!-- end of content left -->

			<!-- end of footer -->
			<!--  Free CSS Template www.templatemo.com -->
		</div>
	</div>
</body>
</html>
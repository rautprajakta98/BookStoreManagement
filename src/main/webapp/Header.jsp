<%@page import="com.onlinebookstore.model.Users"%>
<%@page import="com.onlinebookstore.utility.Constant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store Management</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="templatemo_menu">
    	<ul>
            <li><a href="index.jsp" class="current">Home</a></li>
            
            <%Users users = (Users)session.getAttribute(Constant.LOGEDINUSER);
            if(users==null){
            %>
            <li><a href="Login.jsp">Login</a></li>
            <li><a href="AddUser.jsp">Sign-Up</a></li>
            <li><a href="Contact.jsp">Contact</a></li>
            <%} else{ %>
            <li><a href="AddBook.jsp">AddBook</a></li>
            <li><a href="LoginController?fromPage=logout">Logout</a></li>
            <li><a href="UsersController?fromPage=updateUser&userId=
				<%=users.getUserId()%>">Update Profile</a></li>
				
			<% if(users.isAdmin()==true){ %>
			<li><a href="UsersController?fromPage=allUser">Show All Users</a></li>
			<li><a href="BookController?fromPage=allBook">Show All Book</a></li>
				<% }%>	
			<li><a href="CartController?frompage=allCart&userEmailId=<%=users.getUserEmailId()%>">Show Cart</a></li>	
            <li><a href="OrderController?frompage=allOrders&userEmailId=<%= users.getUserEmailId()%>">Show Orders</a></li>
            
            <%} %>
        
            <% if(users!=null){ %>
            <li class="current" style="font-size:15px;margin-left:10px"> <%= users.getUserName() %></li>
            <% } %>
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $80
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->

 
</body>
</html>
<%@page import="com.onlinebookstore.model.Users"%>
<%@page import="com.onlinebookstore.utility.Constant"%>
<%@page import="com.onlinebookstore.model.Book"%>
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
<script type="text/javascript" src="jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
			$("index.jsp").fadeIn(1000);
			/* $("#div2").fadeIn("slow");
			$("#div3").fadeIn(2000); */
	});
</script>

</head>
<body>

<%
Boolean isSearch=(Boolean)request.getAttribute("isSearch");
List<Book> books = null;
int bookSize=0;
if( isSearch == null || isSearch == false)
{
	BookService bookService=ObjectsUtility.getBookService();
	books=bookService.getAllBook();
	bookSize=4;
	
	//pending code ask nitin
	}
else{
	books =(List<Book>)request.getAttribute("allBook");
	
	bookSize=books.size();
	
}
Users users=(Users) session.getAttribute(Constant.LOGEDINUSER);
%>

<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="SideBar.jsp"></jsp:include>


 <!-- //search  particular book-->
 <center>
<form action="BookController" method="post"   >
<table>
      <tr> 
     <td> <input type="hidden" name="fromPage" value="searchBook"></td>
      <td>   search<input type="text" name="searchkey" > </td>
         <td><input type="submit"></td></tr>
         <tr><td></td><td></td><td></td></tr>
         </table>
</form>
</center>



<% for(int i=0; i<books.size();i++)
	{
	Book book=books.get(i);
	%>
    
    <!-- Right**************** -->
    
     <div id="templatemo_content_right">
        	<div class="templatemo_product_box">
            	<h1><%=book.getBookName()%>  <span>(by <%=book.getBookAuthor() %>)</span></h1>
   	      <img src="images/<%=book.getBookImg()%>" alt="image" style="height:100px; width:100px"/>
                <div class="product_info">
                	<p><%=book.getBookDesc()%></p>
                  <h3>Rs.<%=book.getBookPrice()%></h3>
                  
                  <%if(users!=null){ %>
                    <div class="buy_now_button"><a href="CartController?frompage=buyNow&bookId=<%=book.getBookId()%>">Add To Cart</a></div>
                    <%} %>
                    
                    <div class="detail_button"><a href="BookController?fromPage=detail&bookId=<%=book.getBookId()%>">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
             <div class="cleaner_with_width">&nbsp;</div> 
            <%} %>
              </div> <!-- end of content -->
    

<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>
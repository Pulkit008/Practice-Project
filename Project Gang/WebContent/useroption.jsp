<%@page import="database.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //http 1.1
	response.setHeader("Pragma", "no-cache"); //http1.0
	response.setHeader("Expires", "0"); //proxies

    User uob =(User)session.getAttribute("uob");
    if(uob==null)
    {
    	response.sendRedirect("login.html");
    }%>
    Welcome ${uob.getName()} !
    This is User home page.
    <a href="Logout"><button>Logout</button></a>
    
</body>
</html>
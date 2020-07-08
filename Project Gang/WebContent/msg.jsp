<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <style>
        
    </style>
</head>
<body>
<%! String msg;
    String link;
    String bname;
    String color;%>
<%	
	msg=(String)request.getAttribute("msg");
	link=(String)request.getAttribute("link");
	bname=(String)request.getAttribute("bname");
	color=(String)request.getAttribute("color");
	%>
        
        
    <h3 style="color: <%=color%>"><%=msg %></h3>
    <a href="<%=link%>"><%=bname%></a>
          
</body>
</html>
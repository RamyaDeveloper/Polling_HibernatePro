<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/qlist">Questions</a><br>
<a href="reports.jsp">Reports</a><br>
 

<%
if (request.getSession().getAttribute("name")!=null )
 {%>
   <a href="register.jsp">Add Question</a><br>
   <a href="trendingkeywords.jsp">Trending Keywords</a><br>
    <a href="highpoll.jsp">Trending Keywords</a><br>
    <% }%>
    
<%
if (request.getSession().getAttribute("name")==null )
 {%>
   <a href="signup.jsp">Signup</a><br>
<a href="login.jsp">Login</a><br>
    <% }%>

</body>
</html>
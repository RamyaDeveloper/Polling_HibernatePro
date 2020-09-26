<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/update" method="post">
  <input type="radio" id="male" name="gender" value="yes">
  <label for="male">Yes</label><br>
  <input type="radio" id="female" name="gender" value="no">
  <label for="female">No</label><br>
  <input type="radio" id="other" name="gender" value="not_sure">
  <label for="other">Not Sure</label>
 
  
  <input type="submit" value="Submit">
   <%
String question=request.getParameter("question");
session.setAttribute("question",question);
%>
</form> 
</body>
</html>
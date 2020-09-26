<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach  items="${questionsList}" var="user">

		<c:out value="${user}"/>	<br>
						
	</c:forEach>
	<h3>These are matching questions,Do you still want to add</h3>
	<form action="<%=request.getContextPath()%>/some" method="post">
  <input type="radio" id="male" name="gender" value="add">
  <label for="male">Add</label><br>
  <input type="radio" id="female" name="gender" value="not">
  <label for="female">Not</label><br>
  <input type="submit" value="Submit">
	</form>
	 <%
	 String question=request.getParameter("question");
		  session.setAttribute("question",question);
		  String keywords=request.getParameter("keywords");
session.setAttribute("keywords",keywords);
%>
</body>
</html>
<%@page import="com.dao.UserDao"%>
<%@page import="com.pojo.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% UserDao userDao=new UserDao();
List<User> u=userDao.selectAll();
int i=1;
for(User var:u)
{
	out.print(i++ +". " + var.getQuestion());
	%><br><br>
	<% 
	double s=var.getNo()+var.getNot_sure()+var.getYes();
	double re=var.getYes()/s;
	double re1=var.getNo()/s;
	double re2=var.getNot_sure()/s;
	out.print("Yes: " +Math.round(re*100)+"%  ");
	out.print("No:  "+Math.round(re1*100)+"%  ");
	out.print("Not_Sure: "+ Math.round(re2*100)+"%  ");
	%><br><br><br>
	<% 
}
%>
<c:forEach  items="${listTodo}" var="user">

		<a href="options.jsp?question=${user.question}"><c:out value="${user.question}" /></a>	<br>
		
				
	</c:forEach>

</body>
</html>
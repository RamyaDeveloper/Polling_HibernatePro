<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/sign" method="post">
    <label for="uname"><b>Username</b></label>
    <input type="text"  name="name" >

    <label for="psw"><b>Password</b></label>
    <input type="password"  name="password">
        
         <label for="role"><b>role</b></label>
    <input type="text"  name="role" value="admin">
        
  <input type="submit" value="Submit">
   </form>
 
</body>
</html>
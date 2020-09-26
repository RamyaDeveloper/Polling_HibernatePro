<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%User user = new User();
        UserDao userDao=new UserDao();
        List<User> users=userDao.selectAll();
        int temp=0;
        String t=null;
        int [] poll  = new int[20];  
        String [] questions  = new String[20];  
       int i=0;
       int j=0;
        for(User var:users)
        {
        	int re=var.getYes()+var.getNo()+var.getNot_sure();
        	poll[i++]=re;
        	questions[j++]=var.getQuestion();
        	
        }

		  for(int a=0; a < poll.length; a++){  
            for(int b=1; b< (poll.length-a); b++){  
                     if(poll[b-1] < poll[b]){  
                            //swap elements  
                            temp = poll[b-1];  
                             t=questions[b-1];
                            
                            poll[b-1] = poll[b]; 
                            questions[b-1]=questions[b];
                            
                            poll[b] = temp;  
                            questions[b]=t;
                    }  
                     
            }  
    }  
		
        	   
        for(int z=0;z<3;z++)
  	   {
      out.print(questions[z]);
      %>
      <br>
      <% 
  	   }
       
         %>

</body>
</html>
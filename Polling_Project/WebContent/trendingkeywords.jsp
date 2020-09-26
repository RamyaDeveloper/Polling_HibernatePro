<%@page import="com.pojo.Pairing"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
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
int incr=0;
int max=-999;
int temp=0;
String t=null;
String value=null;
        UserDao userDao=new UserDao();
        List<User> users=userDao.selectAll();
	  String var1[] = new String[30];
	  List<String> kwords=new ArrayList<String>();
	  List<Integer> count=new ArrayList<Integer>();
	  List<String> kwor=new ArrayList<String>();
	  HashMap<String,Integer> hs = new HashMap<String,Integer>(); 
	  Pairing pairs=new Pairing();
	  Pairing pairObjs[]=new Pairing[30];
	  for(int i=0;i<pairObjs.length;i++)
	  {
		  pairObjs[i]=new Pairing();
	  }
	// List<Pairing> pairObjs= new ArrayList<Pairing>();
	  String keyWords[] = new String[35];
	  String dupKwords[] = new String[35];
	  String dupKwords1[] = new String[35];
	  int countVal[] = new int[35];
	  int index=0;
	  int dup=0;
	  int couNt=0;
	 // TreeMap<String, Integer> sorted = new TreeMap<>(); 
	  ArrayList<Integer> sorted = new ArrayList<Integer>();
	  int k=0;
	  for(User var:users)
			 
	  {    
		  var1=var.getKeywords().split(","); 
		  for(k=0;k<var1.length;k++)
	      kwor.add(var1[k]);
		 
	  }
	  
	 for(String iter:kwor)
	 {
		 keyWords[index++]=iter;
		 dupKwords[dup++]=iter;
	 }
	 
	 for(int a=0;a<keyWords.length;a++)
	 {
		 int flag=0;
		 if(keyWords[a]!=null)
		 {
			 for(Pairing check:pairObjs)
			 { 
			 if(keyWords[a].equals(check.getKeyword()))
			 {
				flag=1;
			 } 
			 }
			
		 couNt=0;
		 for(int b=0;b<dupKwords.length;b++)
		 { 
			 if(flag==1)
				 break;
			 if(dupKwords[b]!=null)
			 {
					 if(keyWords[a].equals(dupKwords[b]))
				 	
						 couNt=couNt+1;
			 
			 }
			 else
			 {
				 break;
			 }
				 
				 
			 
		 }
		if(flag!=1)
		{ pairObjs[incr].setKeyword(keyWords[a]);
		
		 pairObjs[incr].setCount(couNt);
			incr=incr+1;
		}
		
		   
		 }
		 else
		 {
			 break;
		 }
		
		
	 }
	int ch=0;
	int ch1=0;
	 for(Pairing p:pairObjs)
	 {
		 if(p.getKeyword()!=null)
		 {
		 
		 dupKwords1[ch++]=p.getKeyword();
		countVal[ch1++]=p.getCount();
		 }
		 
	 }
	 
	

	  for(int i=0; i < ch; i++){  
         for(int j=1; j < (ch-i); j++){  
                  if(countVal[j-1] < countVal[j]){  
                         //swap elements  
                         temp = countVal[j-1];  
                          t=dupKwords1[j-1];
                         
                         countVal[j-1] = countVal[j]; 
                         dupKwords1[j-1]=dupKwords1[j];
                         
                         countVal[j] = temp;  
                         dupKwords1[j]=t;
                 }  
                  
         }  
 }  
	
	      
		  
			 for(int z=0;z<3;z++)
		 	   {
		     out.print(dupKwords1[z]);
		     %>
		     <br>
		     <% 
		 	   }
			 
			
	        %>
         
	
	 
</body>
</html>
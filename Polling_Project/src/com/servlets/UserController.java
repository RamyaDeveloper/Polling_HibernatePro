package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.pojo.User;



@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertQ(request, response);
				break;
			case "/qlist":
				listTod(request, response);
				break;
			case "/update":
				updateOpt(request, response);
				break;
			case "/some":
				dinsert(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTod(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listTodo =userDao.selectAll();
		for (User l:listTodo)
		{
			System.out.println(l);
		}
		request.setAttribute("listTodo", listTodo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		dispatcher.forward(request, response);
	}

	/*private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingTodo = UserDao.selectQid(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		request.setAttribute("todo", existingTodo);
		dispatcher.forward(request, response);
	}*/

	private void insertQ(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
		String question = request.getParameter("question");
		String keywords = request.getParameter("keywords");
	System.out.println(keywords);
		int flag=0;
		User user = new User();
        UserDao userDao=new UserDao();
	  List<User> users=userDao.selectAll();
	  List<String> questionsList=new  ArrayList<String>();
	  List<String> keywordss=new  ArrayList<String>();
	  boolean test=false;
	  int k=0;
	  int index=0;
	  String var1[] = new String[35];
	  String keyWords[] = new String[35];
	  String newkeywords[]=new String[30];
	  System.out.println("var1"+var1);
	  System.out.println("newkeywords"+newkeywords);
	  for(User var:users)
			 
	  {    
		  var1=var.getKeywords().split(","); 
		  for(k=0;k<var1.length;k++)
		  keywordss.add(var1[k]);
		 
	  }
	 
	  for(String iter:keywordss)
	  {
		
		  keyWords[index++]=iter;
	  }
	  for(int i=0;i<keyWords.length;i++)
	  {
		  System.out.println("all kewords"+keyWords[i]);
	  
	  }
	  newkeywords=keywords.split(",");
	  for(int r=0;r<newkeywords.length;r++)
		 System.out.println( "new split keywords"+newkeywords[r]);
	  System.out.println(newkeywords);
	  System.out.println(newkeywords.length);
	 System.out.println("after split newkwrds"+newkeywords);
	  for(String words:newkeywords)
	  { 
		 
		  test  = Arrays.asList(keyWords).contains(words); 
		  	if(test)
		  		{
		  		flag=1;
		  		for(User var:users)
		  			{  
		  				if( var.getQuestion().contains(words))
		  				{
		  					if(!(questionsList.contains(var.getQuestion())))
		  						questionsList.add(var.getQuestion());
		  				}	  			
		             } 
		  		
		  		 }
		  	
	  		}
	  System.out.println("questlist"+questionsList);
	  if(!questionsList.isEmpty())
	  { request.setAttribute("questionsList",questionsList);
	  request.setAttribute("question", question);
	  request.setAttribute("keywords", keywords);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addornot.jsp");
		dispatcher.forward(request,response);
		}
	  System.out.println(test+"testval");
	  /*String addornot=null;
          if(test)
	  addornot=request.getParameter("gender");
           System.out.println(addornot+"addornot");*/
	  if(flag==0 )
	  {
		  user.setKeywords(keywords);
		  user.setNo(0);
	     user.setNot_sure(0);
		user.setQuestion(question);
		user.setYes(0);
		userDao.saveUser(user);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
		dispatcher.forward(request, response);
		}
	
	}

	private void updateOpt(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String opt= request.getParameter("gender");

		HttpSession session=request.getSession(false);
		String ques=(String) session.getAttribute("question");
	     List<User> survey=userDao.selectAll();
	     int i=0;
	     
	     for(User u:survey)
	     {
	    	 if (u.getQuestion().equalsIgnoreCase(ques))
		    	{
	    		 System.out.println("in for"+u);
		    		if(opt.equalsIgnoreCase("yes"))
		    		{	 i=u.getYes();
	    		     i++;
	    		     u.setYes(i);
	    		     userDao.updateOptions(u);
		    		}
		    		
		    		
		    		else if(opt.equalsIgnoreCase("no"))
		    		{
		    			i=u.getNo();
		    		     i++;
		    		     u.setNo(i);
		    		     userDao.updateOptions(u);
		    		}
	    	
		    		else
		    		{	 i=u.getNot_sure();
		    			i++;
		    			u.setNot_sure(i);
		    			userDao.updateOptions(u);
		    		}
		    		
		    	}
	     }
	    	
	    		
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
			dispatcher.forward(request, response);
	}
	private void dinsert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("in dinsert");
		HttpSession session=request.getSession(false);
		String question=(String) session.getAttribute("question");
		String keywords=(String) session.getAttribute("keywords");
		System.out.println("in some"+question);
		System.out.println("in some"+keywords);
		String  addornot=request.getParameter("gender");
		System.out.println("addornot "+addornot);
		User user = new User();
		if(addornot.equalsIgnoreCase("add")){
			System.out.println("in add");
		user.setKeywords(keywords);
		user.setNo(0);
		user.setNot_sure(0);
		user.setQuestion(question);
		user.setYes(0);
		userDao.saveUser(user);	

		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
		dispatcher.forward(request, response);
		}
		else
		{

			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);	
		}
		
		
		
	}

	
	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//UserDao.deleteTodo(id);
		response.sendRedirect("list");
	}
	
}

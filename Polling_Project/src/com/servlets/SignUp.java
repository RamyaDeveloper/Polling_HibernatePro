package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SignUpDao;
import com.pojo.Customer;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/sign")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  SignUpDao signUpDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		signUpDao = new SignUpDao();
	}

    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		Customer customer=new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setRole(role);
		signUpDao.saveCustomer(customer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
		dispatcher.forward(request, response);
		
    
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}

package com.spy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import org.omg.CORBA.Request;

import com.spy.servlet.dab.JavaBean;
import com.spy.servlet.dab.Studentdab;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
 {/*
	 HttpSession session=req.getSession(false);
    String user=(String) session.getAttribute("user1"); 
    String pass=(String) session.getAttribute("pass1");   	
*/


	 doPost(req, resp);
	 
	 
	 
 }

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	response.setContentType("text/html");
		
	PrintWriter out=response.getWriter();
	
	String user=request.getParameter("user");
	String password=request.getParameter("pass");

   // JavaBean bean=new JavaBean();		
	Studentdab st=new Studentdab();
	//ResultSet rs;

	
    boolean result=st.authentication(user, password);	
  
    
    if(result)
    {
    
    	/*HttpSession session=request.getSession(false);
        session.setAttribute("user1",user); 
        session.setAttribute("pass1",password); */  	

    	out.print("successfully login");
    	return;
    	
    }
	  
    else
    {
    	out.println("username or password wrong try again");

        RequestDispatcher e= request.getRequestDispatcher("login.html");
        e.include(request, response);
    	return;
    	
    }
	  
	  
	  
  }
  
  
	}


package com.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.mysql.cj.protocol.x.ReusableOutputStream;

@WebServlet("/Save")
public class SaveServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
		
		  PrintWriter out= response.getWriter();
		  
		    String name= request.getParameter("name");
		    String password=request.getParameter("password");
		    String email=request.getParameter("email");
		    String country=request.getParameter("country");
		     
//		    System.out.println(name + password+email+country);
		    
		         Emp e1=new Emp();
		         
		           e1.setName(name);
		           e1.setPassword(password);
		           e1.setEmail(email);
		           e1.setCountry(country);
		  
		           int status = EmpDao.save(e1);
		           if(status>0) 
		           {
		        	  out.print("record save successfully!!!");
		        	  request.getRequestDispatcher("index.html").include(request, response);  
		        	   
		           }else
		           {
		        	   out.print("somthing went wrong");
		           }
		  
		  
		  
	}
}


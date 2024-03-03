package com.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		  PrintWriter out= response.getWriter();
		
		    out.print("<a href='index.html'>Add New Employee </a>");
		    
		    out.print("<h1>Employee Data Table</h1>");
		    
		         List<Emp>  list=  EmpDao.getAllEMployee();
		         
		         
//		         for(Emp e1 : list ) 
//		         {
//		        	   
//		        	   out.print(e1.getId());
//		        	   out.print(e1.getName());
//		        	   out.print(e1.getPassword());
//		        	   out.print(e1.getEmail());
//		        	   out.print(e1.getCountry());
//		        	   out.print("<br>");
//		        	 
//		         }
//		    
		         
		         out.print("<table width='100%' border='2' cellspacing='0' >");
		         
		                   out.print(" <tr>  <th>Id</th> <th>Name</th> <th>Password</th> <th>Emial</th>   <th>Country</th> <th>Delete</th>  <th>Edit</th></tr>    ");
		                  
		                   for(Emp e1 : list ) 
		      		         {
		                	   out.print("<tr>");
		                	     out.print("<td>"+ e1.getId()+"</td>");
		                	     out.print("<td>"+e1.getName() +"</td>");
		                	     out.print("<td>"+e1.getPassword() +"</td>");
		                	     out.print("<td>"+e1.getEmail() +"</td>");
		                	  
		                	     out.print("<td>"+e1.getCountry() +"</td>");
		                	     out.print("<td><a href='deletServlet?id="+e1.getId()+"'>Delet </td>");
		                	     out.print("<td><a href='editServlet?id="+e1.getId()+"'>Edit</td>");
		                	     out.print("</tr>");
		      		                
		      		         }
		                   
		                  
		                   
		     
		       out.print("</table>");
		    
	}

}
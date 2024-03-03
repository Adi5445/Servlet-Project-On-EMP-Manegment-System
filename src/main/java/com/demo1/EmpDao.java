package com.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







public class EmpDao {

	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/employeeservletdb";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public static Connection getConnection(){  
		 Connection con=null;  
	        try{  
 
	        	// Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");

		         // Open a connection
		          con = DriverManager.getConnection(DB_URL, USER, PASS);
		          
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	
    
    
    public static int save(Emp e1) {
    	
    	     int staus=0;
    	             
    	              
    	                try {
    	                	 Connection con=EmpDao.getConnection();
							PreparedStatement ps= con.prepareStatement("insert into user1(name,password,email,country) values (?,?,?,?)");
					
    	                  ps.setString(1, e1.getName());
    	                  ps.setString(2, e1.getPassword());
    	                  ps.setString(3, e1.getEmail());
    	                  ps.setString(4, e1.getCountry());
							
    	                staus =ps.executeUpdate();
    	                
    	                
    	                
    	                
    	                } catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    	
    	return staus;
    	
    }
    
    public static List<Emp> getAllEMployee() {
    	
  	  ArrayList< Emp> list =new ArrayList<Emp>();
    	    try {
    	    	Connection con =EmpDao.getConnection();
				PreparedStatement ps =con.prepareStatement("select * from user1");
				
				  ResultSet rs= ps.executeQuery();
			
				      while(rs.next())
				      {
				    	     Emp e1= new Emp();
				    	  
				    	      
				    	      e1.setId(rs.getInt(1));
				    	      
				    	      
				    	         e1.setName( rs.getString(2));
				    	       
				    	         e1.setPassword(   rs.getString(3));
				    	         
				    	         e1.setEmail(   rs.getString(4));
				    	         e1.setCountry(   rs.getString(5));
				    	         
				    	         list.add(e1);
				    	          
				      }
				
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	     
    	
    	
    	return list;
    	
    }
    
    
    public static Emp getEmployeeById(int id) 
    {
              
    	 Emp e=new Emp();  
         
         try{  
             Connection con=EmpDao.getConnection();  
             PreparedStatement ps=con.prepareStatement("select * from user1 where id=?");  
             ps.setInt(1,id);  
             ResultSet rs=ps.executeQuery();  
             if(rs.next()){  
                 e.setId(rs.getInt(1));  
                 e.setName(rs.getString(2));  
                 e.setPassword(rs.getString(3));  
                 e.setEmail(rs.getString(4));  
                 e.setCountry(rs.getString(5));  
             }  
             con.close();  
         }catch(Exception ex){ex.printStackTrace();}  
           
         return e;  
    }

    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user1 set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user1 where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 

}
package CA3;

import java.awt.EventQueue;
import java.sql.*;
import java.util.Scanner;

	public class invoiceDriver {
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/projectdb";
   
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Andy3350";


   

   
   static Connection getConnection() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   	   
	   try{
		   
	      //STEP 2: Register JDBC driver
	      //Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected");
	      Statement statement = conn.createStatement();
	     
	   
	   }catch(SQLException se){
		   
	      //Handle errors for JDBC
	      se.printStackTrace();
	      
	   }catch(Exception e){
		   
	      //Handle errors for Class.forName
	      e.printStackTrace();
	      
	   }finally{
		   
	      //finally block used to close resources
	      try{
	    	  
	         if(stmt!=null)
	        	 
	            conn.close();
	         
	      }catch(SQLException se){
	    	  
	      }
	           try{
	                	 
	         if(conn!=null)
	        	 
	             conn.close();
	            
	          }catch(SQLException se){
	        	  
	         se.printStackTrace();
	         
	      }//end finally try
	      
	   }//end try
	   
	   return conn;
	   
	   
   }

   static void muo() {
	   
	   System.out.println("mup");
   }
}//end JDBCExample
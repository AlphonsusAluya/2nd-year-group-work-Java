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
	   
	   
	   @SuppressWarnings("resource")
	   Scanner scanner = new Scanner(System.in);
	   
	   try{
		   
	      //STEP 2: Register JDBC driver
	      //Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected");
	      Statement statement = conn.createStatement();
	     
	      
	      System.out.println("Enter Product ID");
	      int productid=scanner.nextInt();
	      System.out.println("Enter Product Name");
	      String name=scanner.next();
	      System.out.println("Enter Price");
	      String price=scanner.next();
	      System.out.println("Enter VAT");
	      String vat=scanner.next();
	      
	      statement.executeUpdate("insert into product value('"+productid+"','"+name+"' , '"+price+"' , '"+vat+"')");
	      System.out.println("VALUES INSERTED SUCCESSFULLY");
	      
	     
	      //STEP 3: Open a connection
	    /*  System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully..."); 
	      
	      //STEP 4: Execute a query
	    //  System.out.println("Creating table in given database...");
	      stmt = conn.createStatement(); */
	      
	      
	      
	    /* String sql = "INSERT INTO customer (firstname , lastname , address , country) "
	    		  	 + "VALUES ('steve' , 'staunton ' , '17  long road' , 'Ireland')"; */
	      
	   /*   String sql = "INSERT INTO product ( productid , productname , price , vat) "
	    		  	+ "VALUES ('7' ,  'skins' , '.50' , '0.06')";
	      
	      Statement statement = conn.createStatement();
	      
	      int rows = statement.executeUpdate(sql);
	      
	      if (rows > 0 ) {
	    	  
	    	  System.out.println("successfully added to table !");
	      } */
	    	        
	      
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
package com.tcet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.tcet.DBConnect;


public class DBConnect {
//  For connection pipeline
    public Connection con;
    
    // For executing queries 
    public Statement st;
    
    // To store data returned from statement	
    public ResultSet rs;
   
    // Driver required to make SQL Server and application talk.
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    // Database URL (That is database location)
    static final String DB_URL = "jdbc:mysql://localhost:3307/tcet";
    
    // Database username and password.
    static final String DUSER = "root";
    static final String DPASS = "root"; // bad practice to store password like this instead store passwords in env variables.
    
    
    // Holds the query 
    public String query;
    
    // Holds user id. (Can be used as session ID)
    public String UserName;
    
    // Stores update flag. If database updated successfully then its set to true
    int executeUpdate;
    
        
    // Auto connects to database
    public DBConnect(){
        
        try{
            Class.forName(JDBC_DRIVER);
            
            // To set up a connect
            con = DriverManager.getConnection(DB_URL,DUSER,DPASS);
            
            // To execute statement 
            st = con.createStatement();
                      
        }catch(ClassNotFoundException | SQLException ex){System.out.println("Err in connect: " + ex);}
    }
    

    public boolean register(String username, String password,String num,String contact, String address){
        
        try{
            // Check if user already exists in database
            query = String.format("SELECT * FROM register WHERE username = '%s'",username);
            rs = st.executeQuery(query);
           
            // If user does not exists.
            if (rs.next() == false)
            {
                // Inserting into database
                query = String.format("INSERT INTO register(UserName,Password,iscusm,contact,address) VALUES('%s','%s','%s','%s','%s')",username,password,num,contact,address);
                
                // Returns 1 if success.
                executeUpdate = st.executeUpdate(query);
                
                // Insert name into user table
                //query = String.format("INSERT INTO users(name) VALUES('%s')",name);
                                       
                //executeUpdate = st.executeUpdate(query);
                
                if(executeUpdate == 1)
                {
                    System.out.println("Registered Succesfully!");
                    return true;
                }
                System.out.println("Success!");
                
            }
            else
            {                
                System.out.println("Try another username");
                return false;
            }
            
        }catch(Exception ex){System.out.println("Err register: "+ex);}
        
        return false;
    }
    	
    	public boolean car(String carname, String cartype,String carprice,String imagelink){
        
        try{
            // Check if user already exists in database
            query = String.format("SELECT * FROM carmodels WHERE carname = '%s'",carname);
            rs = st.executeQuery(query);
           
            // If user does not exists.
            if (rs.next() == false)
            {
                // Inserting into database
                query = String.format("INSERT INTO carmodels(carname,cartype,carprice,imagelink) VALUES('%s','%s','%s','%s')",carname,cartype,carprice,imagelink);
                
                // Returns 1 if success.
                executeUpdate = st.executeUpdate(query);
                
                // Insert name into user table
                //query = String.format("INSERT INTO users(name) VALUES('%s')",name);
                                       
                //executeUpdate = st.executeUpdate(query);
                
                if(executeUpdate == 1)
                {
                    System.out.println("Car Added Succesfully!");
                    return true;
                }
                System.out.println("Success!");
                
            }
            else
            {                
                System.out.println("Try another Carname");
                return false;
            }
            
        }catch(Exception ex){System.out.println("Err register: "+ex);}
        
        return false;
    }
    
    // For customers stored multiple data but used only username and password for authentication.
    public boolean cuslogin(String username, String password ) {
   	 
      query = String.format("SELECT * FROM register WHERE username= '%s' AND password = '%s' AND iscusm='1'",username,password);
      
      try 
      {            
          rs = st.executeQuery(query);
          
          // If No results returned
          if(rs.next() == false)
          {
           // THEN SHOW ERROR AND DO NOT LET USER LOG IN !           
        	 // System.out.println("Not a customer");
              return false;                
          }
          else
          {     //System.out.println("Hello here");
        	  return true;    
          }
                                  
      } catch (SQLException ex) {
          Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return false;
    }
    public boolean buyc(String buy ) {
      	 
        query = String.format("SELECT carname FROM carmodels WHERE carname= '%s' ",buy);
        
        try 
        {            
            rs = st.executeQuery(query);
            
            // If No results returned
            if(rs.next() == false)
            {
           
                return false;                
            }
            else
            {  


            	query=String.format("DELETE FROM carmodels WHERE carname='%s'",buy);
            	executeUpdate = st.executeUpdate(query);
          	  return true;    
            }
                                    
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
      }
    public boolean ManuFac(String username, String password) {
      	 
        query = String.format("SELECT * FROM register WHERE username = '%s' AND password = '%s' AND iscusm='0'",username,password);
        
        try 
        {            
            rs = st.executeQuery(query);
            
            // If No results returned
            if(rs.next() == false)
            {
             // THEN SHOW ERROR AND DO NOT LET USER LOG IN !
            	//System.out.println("Not a manufacturer");
                return false;                
            }
            else
            {     
            	//System.out.println("Hello here");
          	  return true;    
            }
                                    
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
      }
//    public ArrayList<ShowCar> carList(){
//    	ArrayList<ShowCar> carList = new ArrayList<>();
//    	
//    	try {          
//          
//          query = String.format("SELECT * FROM carmodels");
//          
//          // Select data from database
//          rs = st.executeQuery(query);
//          
//          ShowCar cars;
//          
//          while(rs.next()){
//         	 
//              cars = new ShowCar(rs.getString("carname"),rs.getString("cartype"),rs.getString("carprice"),rs.getString("imagelink"));
//              
//              // Add to car list
//              carList.add(cars);
//              
//          }
// 	 }catch (SQLException ex) {
//          Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
//          System.out.println("I am executed");
//      }
//    	
//    	return carList;
//}
//    
    
    public void close()
    {
        try { rs.close(); } catch (Exception e) { /* ignored */ }
        try { st.close(); } catch (Exception e) { /* ignored */ }
        try { con.close(); } catch (Exception e) { /* ignored */ }
    }
	
	
	
}

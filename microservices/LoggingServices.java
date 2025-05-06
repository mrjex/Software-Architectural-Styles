
/******************************************************************************************************************
 * File: LoggingServices.java
 * Course: DIT345
 * Project: Assignment A4
 * Copyright: Copyright (c) 2018 Carnegie Mellon University
 *
 * Description: This class provides the concrete implementation of the Create microservices. These services run
 * in their own process (RMI).
 *
 * Class Parameters: None
 *
 * Internal Methods:
 *  String newOrder() - creates an order in the ms_orderinfo database from the supplied parameters.
 *
 * External Dependencies:
 *	- rmiregistry must be running to start this server
 *	= MySQL
 - orderinfo database
 ******************************************************************************************************************/
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class LoggingServices extends UnicastRemoteObject implements LoggingServicesAI {
    // Set up the JDBC driver name and database URL
    static final String JDBC_CONNECTOR = "com.mysql.jdbc.Driver";
    static final String DB_URL = Configuration.getJDBCConnection();

    // Set up the orderinfo database credentials
    static final String USER = "root";
    static final String PASS = Configuration.MYSQL_PASSWORD;
    
    
    public LoggingServices() throws RemoteException {
    }

    // Main service loop
    public static void main(String args[]) {
        try {
            LoggingServices obj = new LoggingServices();

            Registry registry = Configuration.createRegistry();
            registry.bind("LoggingServices", obj);

            String[] boundNames = registry.list();
            System.out.println("Registered services:");
            for (String name : boundNames) {
                System.out.println("\t" + name);
            }
            // Bind this object instance to the name DeleteServices' port in the
            // rmiregistry, as per registry.properties

        } catch (Exception e) {
            System.out.println("LoggingServices binding err: " + e.getMessage());
            e.printStackTrace();
        }

    } // main

    public void register(String message) throws RemoteException {
        // Local declarations
        Connection conn = null; // connection to the orderinfo database
        Statement stmt = null; // A Statement object is an interface that represents a SQL statement.

      
        try {
            // Here we load and initialize the JDBC connector. Essentially a static class
            // that is used to provide access to the database from inside this class.
            Class.forName(JDBC_CONNECTOR);

            // Open the connection to the orderinfo database

            // System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Here we execute the addition query. Not that the Statement class is part
            // of the Java.rmi.* package that enables you to submit SQL queries to the
            // database
            // that we are connected to (via JDBC in this case).

            
            stmt = conn.createStatement();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = sdf.format(new Date());
            String msg =message+" at:"+ timestamp;

            String sql = "INSERT INTO loggingActivity(statment) VALUES (\"" + msg + "\")";

            // execute the update
            stmt.executeUpdate(sql);

            // clean up the environment
            stmt.close();
            conn.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            // ReturnString = e.toString();
        }

    }

    public String retrieveLogg() throws RemoteException
    {
      	// Local declarations
        Connection conn = null;		// connection to the orderinfo database
        Statement stmt = null;		// A Statement object is an interface that represents a SQL statement.
        String ReturnString = "[";	// Return string. If everything works you get an ordered pair of data (or [] if list is empty)
        							// if not you get an error string
        try
        {
            // Here we load and initialize the JDBC connector. Essentially a static class
            // that is used to provide access to the database from inside this class.
            Class.forName(JDBC_CONNECTOR);

            //Open the connection to the orderinfo database
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Here we create the query to retrieve the orders.             
            String sql;
            sql = "SELECT * FROM loggingActivity"; 
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while(rs.next())
            {
               String message= rs.getString("statment");
               ReturnString = ReturnString +"{Activity :"+message+"}";
               
            }

            ReturnString = ReturnString +"]";

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            stmt.close(); 
            conn.close();

        } catch(Exception e) {
            System.out.println(e.toString());
            return "something was wrong at server";
        } 
        
        return(ReturnString);

    } // retrieve all Loggs

} 


/******************************************************************************************************************
* File: RetrieveServices.java
* Course: DIT345
* Project: Assignment A4
* Copyright: Copyright (c) 2018 Carnegie Mellon University
*
* Description: This class provides the concrete implementation of the retrieve micro services. These services run
* in their own process (RMI).
*
* Class Parameters: None
*
* Internal Methods:
*  String retrieveOrders() - gets and returns all the orders in the orderinfo database
*  String retrieveOrders(String id) - gets and returns the order matching the provided order id
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

public class RetrieveServices extends UnicastRemoteObject implements RetrieveServicesAI {
    // Set up the JDBC driver name and database URL
    static final String JDBC_CONNECTOR = "com.mysql.jdbc.Driver";
    static final String DB_URL = Configuration.getJDBCConnection();

    // Set up the orderinfo database credentials
    static final String USER = "root";
    static final String PASS = Configuration.MYSQL_PASSWORD;

    // Do nothing constructor
    public RetrieveServices() throws RemoteException {
    }

    // Main service loop
    public static void main(String args[]) {
        // What we do is bind to rmiregistry, in this case localhost, port 1098. This is
        // the default
        // RMI port. Note that I use rebind rather than bind. This is better as it lets
        // you start
        // and restart without having to shut down the rmiregistry.

        try {
            RetrieveServices obj = new RetrieveServices();

            Registry registry = Configuration.createRegistry();
            registry.bind("RetrieveServices", obj);

            String[] boundNames = registry.list();
            System.out.println("Registered services:");
            for (String name : boundNames) {
                System.out.println("\t" + name);
            }

        } catch (Exception e) {

            System.out.println("RetrieveServices binding err: " + e.getMessage());
            e.printStackTrace();
        }

    } // main

    // This method returns all the entries in the orderinfo datastore
    public String retrieveOrders() throws RemoteException {
        // Local declarations
        Connection conn = null; // connection to the orderinfo database
        Statement stmt = null; // A Statement object is an interface that represents a SQL statement.
        String ReturnString = "["; // Return string. If everything works you get an ordered pair of data (or [] if
                                   // list is empty)
                                   // if not you get an error string
        try {
            // Here we load and initialize the JDBC connector. Essentially a static class
            // that is used to provide access to the database from inside this class.
            Class.forName(JDBC_CONNECTOR);

            // Open the connection to the orderinfo database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // Here we create the query to retrieve the orders.
            String sql;
            sql = "SELECT * FROM orders";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("order_id");
                String date = rs.getString("order_date");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                // Display values
                // System.out.print("ID: " + id);
                // System.out.print(", date: " + date);
                // System.out.print(", first: " + first);
                // System.out.print(", last: " + last);
                // System.out.print(", address: " + address);
                // System.out.println("phone:"+phone);

                ReturnString = ReturnString + "{order_id:" + id + ", order_date:" + date + ", first_name:" + first
                        + ", last_name:"
                        + last + ", address:" + address + ", phone:" + phone + "}";

            }

            ReturnString = ReturnString + "]";

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            ReturnString = e.toString();
        }

        return (ReturnString);

    } // retrieve all orders

    // This method returns the order from the orderinfo database, corresponding to
    // the id
    // provided in the argument.
    public String retrieveOrders(String orderid) throws RemoteException {
        // Local declarations
        Connection conn = null; // connection to the orderinfo database
        Statement stmt = null; // A Statement object is an interface that represents a SQL statement.
        String ReturnString = "["; // Return string. If everything works you get an ordered pair of data
                                   // if not you get an error string

        try {
            // Here we load and initialize the JDBC connector. Essentially a static class
            // that is used to provide access to the database from inside this class.
            Class.forName(JDBC_CONNECTOR);

            // Open the connection to the orderinfo database

            // System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Here we create the query to be executed.
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM orders where order_id=" + orderid;
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set. Note there should only be one for this method.
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("order_id");
                String date = rs.getString("order_date");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                // Display values
                // System.out.print("ID: " + id);
                // System.out.print(", date: " + date);
                // System.out.print(", first: " + first);
                // System.out.print(", last: " + last);
                // System.out.print(", address: " + address);
                // System.out.println("phone:"+phone);

                ReturnString = ReturnString + "{order_id:" + id + ", order_date:" + date + ", first_name:" + first
                        + ", last_name:"
                        + last + ", address:" + address + ", phone:" + phone + "}";
            }

            ReturnString = ReturnString + "]";

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
            ReturnString = e.toString();
        }

        return (ReturnString);

    } // retrieve order by id

} // RetrieveServices
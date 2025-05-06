/******************************************************************************************************************
 * File: CreateServicesAI.java
 * Course: DIT345
 * Project: Assignment A4
 * Copyright: Copyright (c) 2018 Carnegie Mellon University
 *
 * Description: This class provides the interface for the order creation microservice, CreateServices.
 * The implementation of this interface can be found in the CreateServices.java class. Note that
 * services can be initiated separately, and isolated by the port# they are hosted on. For this assignment,
 * Create and Retrieve services have already been provided, and services are to be hosted on the localhost,
 * on RMI ports 1099 and 1098 respectively.
 *
 * Parameters: None
 *
 * Internal Methods:
 *  String newOrder(Date, FirstName, LastName, Address, Phone) - creates a new order in the orderinfo database
 *
 * External Dependencies: None
 ******************************************************************************************************************/

import java.rmi.*;

public interface DeleteServicesAI extends java.rmi.Remote
{
    /*******************************************************
     * Removes an order using the provided ID.
     * Returns an OK message or an error string.
     *******************************************************/

    String removeOrder(String id) throws RemoteException;
}
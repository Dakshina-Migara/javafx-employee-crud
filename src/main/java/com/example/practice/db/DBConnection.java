package com.example.practice.db;

//represents a connection to the database
import java.sql.Connection;
//create the database connection
import java.sql.DriverManager;
//sql errors handle
import java.sql.SQLException;

public class DBConnection {

    //static is owner of the class
    //final is cannot be change
    private static final String URL = "jdbc:mysql://localhost:3306/sanka_seafood";
    //database user name
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    //dbConnection object
    //purpose is to store and control ONE single DBConnection object for the entire application.
    private static DBConnection dbConnection;
    //actual database connection and use to execute sql query
    private Connection connection;

    //use the private for prevent create objects
    //this is constructor
    private DBConnection() throws SQLException {
        //connect to the MySql
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //create once reuse always
    public static DBConnection getInstance() throws SQLException {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        //return the dbConnection object back to the caller
        return dbConnection;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        //return the Connection object
        //return the database connection
        return connection;
    }

    //singleton pattern = only one DBConnection object
}

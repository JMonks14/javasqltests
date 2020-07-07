package com.qa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class runner {
	
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    refers to my GCP instance
//    static final String DB_URL = "jdbc:mysql://35.234.143.115/sakila";
//    Local host on my machine
    static final String DB_URL = "jdbc:mysql://localhost:3306/ims_project";

 

////    static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
//
//    // Database credentials
    static final String USER = "root";
    static final String PASS = "root";

 

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Customer Jeff = new Customer("Jeff", "Rigdeley", "upgolfer", "iamboring");
        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

 

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            runner.create(Jack, conn);
            
 

            // STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            
            String sql1;
            sql1 = Jeff.inString();
            stmt.execute(sql1);
    
            String sql;
            sql = "SELECT * FROM Customers";
            ResultSet rs = stmt.executeQuery(sql);
            
            

            // STEP 5: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("cust_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                

                // Display values
                System.out.println("Fetching information!");
                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
//            
            
            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
//         finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }// end main

    public static void create(Customer customer, Connection conn) {
        try(Statement statement = conn.createStatement()) {

            statement.executeUpdate("INSERT INTO customers(first_name, surname, username, password) VALUES('" +
                customer.getFirst_name() + "','" + customer.getLast_name() + "','" + customer.getUsername() + "','" + customer.getPassword() +"')");
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());

}

    }

}


// end FirstExample	
	


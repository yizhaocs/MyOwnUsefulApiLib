package main.java;

import java.sql.*;

/**
 * Created by yizhao on 7/29/15.
 */
public class JDBCMain {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ThreatStream";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            showBooks(connection);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    private static void showBooks(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT isbn, title, publisher, year FROM Book";
            ResultSet result = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (result.next()) {
                //Retrieve by column name
                int isbn = result.getInt("isbn");
                String title = result.getString("title");
                String publisher = result.getString("publisher");
                int year = result.getInt("year");

                //Display values
                System.out.print("isbn: " + isbn);
                System.out.print(", title: " + title);
                System.out.print(", publisher: " + publisher);
                System.out.println(", year: " + year);
            }
            //STEP 6: Clean-up environment
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

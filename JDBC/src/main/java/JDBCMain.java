package main.java;

import java.sql.*;
import java.util.*;

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
            threamStream(connection);
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

    private static void showBooksInnerJoinWithAuthor(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT Book.isbn, Book.title, Book.publisher, Book.year, AUTHOR.name FROM Book JOIN AUTHOR ON Book.isbn = AUTHOR.isbn ORDER BY AUTHOR.rank";
            ResultSet result = statement.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (result.next()) {
                //Retrieve by column name
                int isbn = result.getInt("isbn");
                String title = result.getString("title");
                String publisher = result.getString("publisher");
                int year = result.getInt("year");
                String name = result.getString("name");

                //Display values
                System.out.print("isbn: " + isbn);
                System.out.print(", title: " + title);
                System.out.print(", publisher: " + publisher);
                System.out.print(", year: " + year);
                System.out.println(", name: " + name);
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

    private static void threamStream(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT Book.isbn, Book.title, Book.publisher, Book.year, AUTHOR.name FROM Book JOIN AUTHOR ON Book.isbn = AUTHOR.isbn ORDER BY AUTHOR.rank";
            ResultSet queryResult = statement.executeQuery(sql);


            Map<String, ResultDTO> finalResult = new HashMap<>();
            //STEP 5: Extract data from result set
            while (queryResult.next()) {
                //Retrieve by column name
                String title = queryResult.getString("title");
                String publisher = queryResult.getString("publisher");
                int year = queryResult.getInt("year");
                String name = queryResult.getString("name");

                ResultDTO curResultDTO;
                if (finalResult.containsKey(title)) {
                    curResultDTO = finalResult.get(title);
                    curResultDTO.getAuthors().add(name);
                } else {
                    List<String> authors = new ArrayList<>();
                    authors.add(name);
                    curResultDTO = new ResultDTO();
                    curResultDTO.setTitle(title);
                    curResultDTO.setAuthors(authors);
                    curResultDTO.setPublisher(publisher);
                    curResultDTO.setYear(year);
                    finalResult.put(title, curResultDTO);
                }
            }

            Set<String> titleSet = finalResult.keySet();
            for (String title : titleSet) {
                System.out.println("title: " + finalResult.get(title).getTitle());
                for(String author: finalResult.get(title).getAuthors()){
                    System.out.println("  author: " + author);
                }
                System.out.println("publisher: " + finalResult.get(title).getPublisher() + "  , year:" + finalResult.get(title).getYear());
                System.out.println();
            }
            //STEP 6: Clean-up environment
            queryResult.close();
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

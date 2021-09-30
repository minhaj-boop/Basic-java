/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author HP
 */
public class DBConsoleApplication {

    /**
     * @param args the command line arguments
     */
    private final String USERNAME = "spring2018java";
    private final String PASSWORD = "java";
    private final String HOSTNAME = "192.168.0.103";
    private final String DBNAME = "studentdb";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    public void retrieveData(){
        
        try {
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connected.");
            
            String query = "select * from student";
            
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            System.out.println("Retrieved data.");
            
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                System.out.println(id + "  " + name + "  " + address + "  " + phone);
            }
            
        } catch (SQLException sqle) {
          System.err.println("some error happened!" + sqle);
        }
    }
    
    public void insertData(){
        
        try {
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connected.");
            
            String query = "insert into student values('0909', 'Mrs Fatema', 'somewhere', '0507074962');";
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
            
            connection.close();
            
            System.out.println("Record inserted.");
        } catch (SQLException sqle) {
          System.err.println("some error happened!" + sqle);
        }
        
    }
    
    public DBConsoleApplication() {
       //insertData();
       retrieveData();
    }
    
    public static void main(String[] args) {
        DBConsoleApplication a = new DBConsoleApplication();
    }
    
}

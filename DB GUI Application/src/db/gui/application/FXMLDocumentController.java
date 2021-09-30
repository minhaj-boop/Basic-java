/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.gui.application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
 
    private final String USERNAME = "spring2018java";
    private final String PASSWORD = "java";
    private final String HOSTNAME = "192.168.0.103";
    private final String DBNAME = "studentdb";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label statusLabel;
    @FXML
    private ListView<Student> studentListView;
    private ObservableList<Student> studentList;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> addressColumn;
    @FXML
    private TableColumn<Student, String> phoneColumn;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentList = FXCollections.observableArrayList();
        studentListView.setItems(studentList);
        studentTableView.setItems(studentList);
        idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        
        addressColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAddress()));
        
        phoneColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPhone()));
        
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
                
                Student s = new Student(id, name, address, phone);
                studentList.add(s);
            }
            
        } catch (SQLException sqle) {
          //System.err.println("some error happened!" + sqle);
            //System.err.println("Some error happened! " + sqle);
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error!" + sqle);

            alert.showAndWait();
        }
        
    }    

    @FXML
    private void handleAddStudentAction(ActionEvent event) {
        
          try {
            statusLabel.setText("Connecting to database...");
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            statusLabel.setText("Connected.");
            
            String id = idField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            
            String query = "insert into student values('" + id + "', '" + name + "', '" + address + "', '" + phone + "');";
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(query);
            
            statusLabel.setText("Record inserted.");
            
            resetForm();
            
            Student s = new Student(id, name, address, phone);
            studentList.add(s);
            
            connection.close();
        } catch (SQLException sqle) {
          //System.err.println("some error happened!" + sqle);
            //System.err.println("Some error happened! " + sqle);
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error!" + sqle);

            alert.showAndWait();
        }
    }
    
    public void resetForm(){
        idField.clear();
        nameField.clear();
        addressField.clear();
        phoneField.clear();
    }
    
}

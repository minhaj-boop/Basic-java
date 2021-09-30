/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

    private double num1;
    private double num2;
    String operation;
    @FXML
    private TextField displayTextField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleZeroAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "0";
        else newValue = oldValue + "0";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleThreeAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "3";
        else newValue = oldValue + "3";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "2";
        else newValue = oldValue + "2";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "1";
        else newValue = oldValue + "1";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleFourAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "4";
        else newValue = oldValue + "4";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleSixAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "6";
        else newValue = oldValue + "6";
        displayTextField.setText(newValue); 
    }
    
    @FXML
    private void handleFiveAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "5";
        else newValue = oldValue + "5";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleNineAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "9";
        else newValue = oldValue + "9";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleEightAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "8";
        else newValue = oldValue + "8";
        displayTextField.setText(newValue); 
    }

    @FXML
    private void handleSevenAction(ActionEvent event) {
        
        String oldValue = displayTextField.getText();
        String newValue;
        if (oldValue.startsWith("0"))
            newValue = "7";
        else newValue = oldValue + "7";
        displayTextField.setText(newValue); 
    }
    
    @FXML
    private void handleDivisionAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num1 = Double.parseDouble(oldValue);
        displayTextField.clear();
        operation = "DIVISION";
        
    }
    
    @FXML
    private void handleSubtractionAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num1 = Double.parseDouble(oldValue);
        displayTextField.clear();
        operation  = "SUBTRACTION";
    }

    @FXML
    private void handleMultiplicationAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num1 = Double.parseDouble(oldValue);
        displayTextField.clear();
        operation = "MULTIPLICATION";
    }
    
    @FXML
    private void handleAdditionAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num1 = Double.parseDouble(oldValue);
        displayTextField.clear();
        operation = "ADDITION";
    }
    
    @FXML
    private void handleEqualAction(ActionEvent event) {
        String oldValue = displayTextField.getText();
        num2 = Double.parseDouble(oldValue);
        
        double result = 0;
        
        if(operation.equals("ADDITION"))
            result = num1 + num2;
        else if(operation.equals("SUBTRACTION"))
            result = num1 - num2;
        else if(operation.equals("MULTIPLICATION"))
            result = num1 * num2;
        else if(operation.equals("DIVISION"))
            result = num1 / num2;
        
        displayTextField.setText("" + result);
    }
    
}

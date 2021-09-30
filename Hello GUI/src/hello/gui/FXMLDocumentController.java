/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField firstTextField;
    @FXML
    private TextField secondTextField;
    @FXML
    private Button copyButton;
    @FXML
    private TextField thirdTextField;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCopyAction(ActionEvent event) {
        String text =  firstTextField.getText();
        text = text.toUpperCase();
        text = text.trim();
        secondTextField.setText(text);
        firstTextField.clear();
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            if(text.charAt(i) == 'A' || text.charAt(i) == 'E'||
                    text.charAt(i) == 'I' || text.charAt(i) == 'O' ||
                    text.charAt(i) == 'U')
                count++;
                
        }
        String numberOfVowels = Integer.toString(count);
        thirdTextField.setText(numberOfVowels);
    }

    
}

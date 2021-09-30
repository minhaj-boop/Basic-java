/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.analyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField fileNameTextField;
    @FXML
    private Button fileOpenButton;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField wordsTextfield;
    @FXML
    private TextField characterTextFeld;
    @FXML
    private TextField diigtTextField;
    @FXML
    private TextField vowelsTextField;
    @FXML
    private TextField sentencesTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleFiileOpenAction(ActionEvent event) {

        String fileName = fileNameTextField.getText();

        textArea.clear();

        try {

            RandomAccessFile input = new RandomAccessFile(fileName, "r");
            
            String line;
            String fileContent = "";
            while (true){
                line = input.readLine();
                if(line == null)
                    break;
                // The following line is ugly!
                // We should use StringBuilder instead
                fileContent = fileContent + " " + line;
                textArea.appendText(line + "\n");                
            }
            int words = countWords(fileContent);
            
            int sentences = countSentences(fileContent);
            
            int characters = countCharacters(fileContent);
            
            int digits = countDigits(fileContent);
            
            int vowels = countVowels(fileContent);
            
            wordsTextfield.setText("" + words);
            
            sentencesTextField.setText("" + sentences);
            
            characterTextFeld.setText("" + characters);
            
            diigtTextField.setText("" + digits);
            
            vowelsTextField.setText("" + vowels);
        } catch (FileNotFoundException ex) {
            System.err.println("File does not exist");
        }catch(IOException ex){
             System.err.println("Some I/O exception occured");            
        }

    }
    
    private int countWords(String filecontent) {
        // For future:
        // Once you've completed CSE3025, revisit this problem
        // You need to know what Regular Expressions are
        int count = 0;
        
        while (filecontent.contains("  "))
            filecontent = filecontent.replaceAll("  ", " ");
        filecontent = filecontent.trim();
        
        for (int i = 0; i < filecontent.length(); i++)
            if (filecontent.charAt(i) == ' ' || filecontent.charAt(i) == ',')
                count++;
        
        if (filecontent.length() != 0)
            return count;
        else return 0;
    }

    private int countSentences(String fileContent) {
        int count = 0;
        for(int i = 0; i < fileContent.length(); i++){
            
            if(fileContent.charAt(i) == '.'){
                count++;
            }
        }
        return count;
    }

    private int countCharacters(String fileContent) {
        int count = 0;
        for(int i = 0; i < fileContent.length(); i++){
            
            if(fileContent.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }

    private int countDigits(String fileContent) {
        int count = 0;
        for(int i = 0; i < fileContent.length(); i++){
            
            if(fileContent.charAt(i) >= '0' && fileContent.charAt(i) <= '9'){
                count++;
            }
        }
        return count;
    }

    private int countVowels(String fileContent) {
        int count = 0;
        
        for(int i = 0; i < fileContent.length(); i++){
         if(fileContent.charAt(i) == 'A' 
                 || fileContent.charAt(i) == 'E' 
                 || fileContent.charAt(i) == 'I'
                 || fileContent.charAt(i) == 'O'
                 || fileContent.charAt(i) == 'U'
                 || fileContent.charAt(i) == 'a'
                 || fileContent.charAt(i) == 'e'
                 || fileContent.charAt(i) == 'i'
                 || fileContent.charAt(i) == 'o'
                 || fileContent.charAt(i) == 'u'){ 
             count++;
         } 
        }
        return count;
    }

}

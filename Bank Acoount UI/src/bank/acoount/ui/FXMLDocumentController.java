/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.acoount.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField accountIdTextField;
    @FXML
    private TextField accountNameTextField;
    @FXML
    private TextArea addressTextField;
    @FXML
    private TextField balanceTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
    }

    @FXML
    private void handleCreateAccountAction(ActionEvent event) {
        long accountID = Long.parseLong(accountIdTextField.getText());
        String accountName = accountNameTextField.getText();
        String address = addressTextField.getText();
        double balance = Double.parseDouble(balanceTextField.getText());

        BankAccount bankAccount = new BankAccount(accountID, accountName, address, balance);

        System.out.println(bankAccount);

        try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Acoount UI\\accounts.txt", "rw");
            long length = output.length();
            output.seek(length);
            output.writeBytes(bankAccount + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

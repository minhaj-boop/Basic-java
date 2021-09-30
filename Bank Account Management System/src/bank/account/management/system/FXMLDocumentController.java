/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.management.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Minhaj
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField numberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea addressArea;
    @FXML
    private TextField balanceField;
    private ObservableList <BankAccount> bankAccountList;
    private ObservableList <BankAccount> filteredBankAccountList;
    @FXML
    private TextField searchField;
    @FXML
    private ListView <BankAccount> accountListView;
    private BankAccount selectedAccount;
    @FXML
    private DatePicker transactionDatePicker;
    @FXML
    private TextField transactionTimeField;
    @FXML
    private ComboBox<BankAccount> accountComboBox;
    @FXML
    private ComboBox<TransactionType> transactionTypeComboBox;
    @FXML
    private TextField amountFiled;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           bankAccountList = FXCollections.observableArrayList();
           
           filteredBankAccountList = FXCollections.observableArrayList();
           
           accountListView.setItems(filteredBankAccountList);
           
           accountComboBox.setItems(filteredBankAccountList);
           
           ObservableList <TransactionType> transactionTypeList = FXCollections.observableArrayList();
           transactionTypeList.addAll(TransactionType.values());
           transactionTypeComboBox.setItems(transactionTypeList);
           
           LocalDate currentDate = LocalDate.now();
           transactionDatePicker.setValue(currentDate);
           
           LocalTime currentTime = LocalTime.now();
           transactionTimeField.setText(currentTime.toString());
           
        try {
            RandomAccessFile input = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Account Management System\\accounts.txt", "r");
            
            int accountNumber = 0;
            String accountName = "";
            String address = "";
            double balance = 0.0;
            int countData = 0;
            
            while(true){
                String line = input.readLine();
                
                if(line == null)
                    break;
                
                String tokens[] = line.split(":");
                
                switch(tokens[0]){
                    case "accountNumber":
                        accountNumber = Integer.parseInt(tokens[1]);
                        countData++;
                        break;
                    case "accountName":
                        accountName = tokens[1];
                        countData++;
                        break;
                    case "address":
                        address = tokens[1];
                        countData++;
                        break;
                    case "balance":
                        balance = Double.parseDouble(tokens[1]);
                        countData++;
                        break;
                    default:
                        System.err.println("Invalid input");
                        break;
                }
                
                if(countData % 4 == 0){
                    BankAccount account = new BankAccount(accountNumber, accountName, address, balance);
                    bankAccountList.add(account);
                }
            }
            
            filteredBankAccountList.addAll(bankAccountList);
            
             for (int i = 0; i < bankAccountList.size(); i++) {
                System.out.println(bankAccountList.get(i)); 
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
        clearForm();
        numberField.setText(BankAccount.getTotalAccounts() + 1 + "");
    }

    public void clearForm(){
        numberField.clear();
        nameField.clear();
        addressArea.clear();
        balanceField.clear();
        
    }
    
    @FXML
    private void handleCreateAction(ActionEvent event) {
        String accountName = nameField.getText();
        String address = addressArea.getText();
        double balance = Double.parseDouble(balanceField.getText());
        
        BankAccount account = new BankAccount(accountName, address, balance);
        
        try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Account Management System\\accounts.txt", "rw");
            
            output.seek(output.length());
            
            output.writeBytes(account.getAllData()+ "\n");
            
            bankAccountList.add(account);
            filteredBankAccountList.add(account);
            
            output.close();
            
            clearForm();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        String updatedAddres = addressArea.getText();
        selectedAccount.setAddress(updatedAddres);
        
        try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Account Management System\\accounts.txt", "rw");
        
            output.setLength(0);
            
            for(int i = 0; i < bankAccountList.size(); i++){
                output.writeBytes(bankAccountList.get(i).getAllData() + "\n");
            }
            
            output.close();
            
            clearForm();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void filter(){
        filteredBankAccountList.clear();
        String name = searchField.getText().toLowerCase();
        for(int i = 0; i < bankAccountList.size(); i++){
            BankAccount account = bankAccountList.get(i);
            if(account.getAccountName().toLowerCase().contains(name))
                filteredBankAccountList.add(account);
        }
    }
    
    @FXML
    private void handleFilterAction(ActionEvent event) {
        filter();
    }

    @FXML
    private void handleKeyFilterAction(KeyEvent event) {
        filter();
    }

    private void displayData(BankAccount account){
        numberField.setText(account.getAccountNumber() + "");
        nameField.setText(account.getAccountName());
        addressArea.setText(account.getAddress().replaceAll(";", "\n"));
        balanceField.setText(account.getBalance() + "");
        
    }
    
    @FXML
    private void handleListClickAction(MouseEvent event) {
        selectedAccount = accountListView.getSelectionModel().getSelectedItem();
        displayData(selectedAccount);
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        
        try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Account Management System\\transactions.txt", "rw");
            
            output.seek(output.length());
            
            BankAccount bankAccount = accountComboBox.getSelectionModel().getSelectedItem();
            TransactionType transactionType = transactionTypeComboBox.getSelectionModel().getSelectedItem();
            LocalDate transactionDate = transactionDatePicker.getValue();
            LocalTime transactionTime = LocalTime.parse(transactionTimeField.getText());
            double amount = Double.parseDouble(amountFiled.getText());
            
            bankAccount.withdraw((long) amount);
            
            Transaction transaction = new Transaction(bankAccount, transactionType, transactionDate, transactionTime, amount);
            
            output.writeBytes(transaction.getAllData() + "\n");
            
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\Bank Account Management System\\accounts.txt", "rw");
        
            output.setLength(0);
            
            for(int i = 0; i < bankAccountList.size(); i++){
                output.writeBytes(bankAccountList.get(i).getAllData() + "\n");
            }
            
            output.close();
            
            clearForm();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

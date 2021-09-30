/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.management.system;

import javafx.scene.control.Alert;

/**
 *
 * @author HP
 */
public class BankAccount {

    private int accountNumber;
    private String accountName;
    private String address;
    private double balance;
    private static int totalAccounts;

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public BankAccount(int accountNumber, String accountName, String address, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.address = address;
        this.balance = balance;
        totalAccounts++;
    }

    public BankAccount(String accountName, String address, double balance) {
        this.accountNumber = totalAccounts + 1;
        this.accountName = accountName;
        this.address = address;
        this.balance = balance;
        totalAccounts++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return accountNumber + ": " + accountName;

    }

    public String getAllData() {
        return "accountNumber:" + accountNumber + "\n"
                + "accountName:" + accountName + "\n"
                + "address:" + address.replaceAll("\n", ";") + "\n"
                + "balance:" + balance;
    }

    public void withdraw(long amount) {
        // Homework: try to modify this method so that it only allows you to
        // withdraw amount that are multiples of 500
        if (amount <= balance && amount > 0 && amount % 500 == 0) {
            balance = balance - amount;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            //alert.setHeaderText("Look, an Error Dialog");
            if (amount % 500 != 0)
                alert.setContentText("Cannot withdraw the requested amount. please withdraw amount that is a multiple of 500");
            else
                alert.setContentText("Sorry! No sufficient balance.");
           
            alert.showAndWait();
        }
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            //alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Sorry! Connot deposit the requested amount.");

            alert.showAndWait();
        }
    }
}

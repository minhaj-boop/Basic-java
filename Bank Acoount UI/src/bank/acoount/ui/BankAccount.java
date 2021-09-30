/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.acoount.ui;

/**
 *
 * @author HP
 */
public class BankAccount {
    private long accountID;
    private String accountName;
    private String address;
    private double balance;

    public BankAccount(long accountID, String accountName, String address, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.address = address;
        this.balance = balance;
    }

    public long getAccountID() {
        return accountID;
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
    
    public void withdraw(int amount){
        balance -= balance;
    }
    
    public void deposit(int amount){
        balance +=balance;
    }
    
    public String toString(){
        return String.format("ID: %d, Name: %s, Balance: %.2f", accountID, accountName, balance);
    }
    
}

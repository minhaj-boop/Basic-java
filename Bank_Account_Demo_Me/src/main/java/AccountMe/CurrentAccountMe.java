/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountMe;

/**
 *
 * @author HP
 */
public class CurrentAccountMe {
    
    private long accountId;
    private String accountName;
    private String address;
    private double balance;

    public CurrentAccountMe(long accountId, String accountName, String address, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.address = address;
        this.balance = balance;
    }

    public boolean withdraw(long amount) {
        // Homework: try to modify this method so that it only allows you to
        // withdraw amount that are multiples of 500
        if (amount + 15 <= balance && amount > 0 && amount%500 == 0) {
            balance = balance - amount - 15;
            return true;
        } else {
            System.err.printf("You do not have sufficient balance\n");
            return false;
        }
    }

    public boolean deposit(long amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        } else {
            System.err.println("Depositing negative amount is not allowed\n");
            return false;
        }
    }

    public void print() {
        System.out.printf("Id: %d Name: %s Balance: %.2f\n", accountId, accountName, balance);
    }

    public long getAccountId() {
        return accountId;
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
    
}

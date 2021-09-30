/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.management.system;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author HP
 */
public class Transaction {
    private BankAccount bankAccount;
    private TransactionType transactionType;
    LocalDate transactionDate;
    LocalTime transctionTime;
    double amount;

    public Transaction(BankAccount bankAccount, TransactionType transactionType, LocalDate transactionDate, LocalTime transctionTime, double amount) {
        this.bankAccount = bankAccount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.transctionTime = transctionTime;
        this.amount = amount;
    }
    
    public String getAllData(){
        return bankAccount.getAccountName() + ";" +
               transactionType.toString() + ";" +
               transactionDate.toString() + ";" +
               transctionTime.toString() + ";" +
               amount;
    }
}

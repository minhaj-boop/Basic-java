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
public class CurrentAccount2Me extends BankAccountMe{
    
    public CurrentAccount2Me(long accountId, String accountName, String address, double balance) {
        super(accountId, accountName, address, balance);
    }
    
    @Override
    public boolean withdraw(long amount) {
        
        if (amount <= balance && amount > 0 && amount%500 == 0) {
            balance = balance - amount;
            return true;
        } else {
            System.err.printf("You do not have sufficient balance\n");
            return false;
        }
    }
    
}

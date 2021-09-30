/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.demo.me;

import AccountMe.BankAccountMe;
import AccountMe.CreditCardMe;
import AccountMe.CurrentAccountMe;
import AccountMe.SavingsAccountMe;

/**
 *
 * @author HP
 */
public class BankAccountDemoMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankAccountMe b1 = new BankAccountMe(2331, "Rajon Bardhan", "Moghbazar", 5000);
        BankAccountMe b2 = new BankAccountMe(6587, "Md. Ashiqur Rahman", "Notun Bazaar", 6000);
        CurrentAccountMe b3 = new CurrentAccountMe(8741, "Md. Hasan Tareque", "Shantinagar", 1000);
        CreditCardMe b4 = new CreditCardMe(9999, "Minhaj", "Boshundhara", 50000);
        SavingsAccountMe b6 = new SavingsAccountMe(1010, "Mairan", "Mogbazar", 10000);
        
        b1.deposit(5000);
        b1.withdraw(1000);
        
        b2.deposit(5000);
        b2.withdraw(10000);
        
        b3.deposit(1000);
        b3.withdraw(500);
        
        
        b4.withdraw(500);
        b4.withdraw(10000);
        b4.withdraw(20000);
        b4.deposit(500);
        b4.withdraw(20000);
        b6.deposit(10000);
        b6.withdraw(2000);
        b6.withdraw(1000);
        
        //b5.withdraw(1000);
        
        b1.print();
        b2.print();
        b3.print();
        b4.print();
        b6.print();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOPDemo;

/**
 *
 * @author HP
 */
public class RationalNumber {
    
    private long numerator;
    private long denominator;

    public RationalNumber(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }
    
    public RationalNumber add(RationalNumber b) {
        RationalNumber a = this;
        
        long n = a.numerator * b.denominator + a.denominator * b.numerator;
        long d = a.denominator * b.denominator;
        
        RationalNumber c = new RationalNumber(n, d);
        
        return c;
    }
    
    public RationalNumber subtract(RationalNumber b) {
        RationalNumber a = this;
        
        long n = a.numerator * b.denominator - a.denominator * b.numerator;
        long d = a.denominator * b.denominator;
        
        RationalNumber c = new RationalNumber(n, d);
        
        return c;
    }

        
    public RationalNumber multiply(RationalNumber b) {
        RationalNumber a = this;
        
        long n = a.numerator * b.numerator;
        long d = a.denominator * b.denominator;
        
        RationalNumber c = new RationalNumber(n, d);
        
        return c;
    }
    
    public RationalNumber divide(RationalNumber b) {
        return this.multiply(new RationalNumber(b.denominator, b.numerator));
    }
    
    private void reduce() {
        long a = numerator;
        long b = denominator;
        
        while (b % a != 0) {
            long x = b % a;
            long y = a;
            
            a = x;
            b = y;
        }

        long divisor = a;        
        
        numerator = numerator / divisor;
        denominator = denominator / divisor;
    }
    
    public void print() {
        System.out.printf("%d/%d\n", numerator, denominator);
    }
    
}

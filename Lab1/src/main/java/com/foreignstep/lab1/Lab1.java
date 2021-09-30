/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foreignstep.lab1;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Lab1 {
   
    //Task 1: Read two numbers from the user 
    // and print the result
    public static void task1(){
        
        System.out.printf("Enter two numbers: \n");
        Scanner scan = new Scanner(System.in);
        
        int x = scan.nextInt();
        int y = scan.nextInt();
        
        int result = x + y;
        
        System.out.printf("The result of addition: %d\n", result);
    }
   
    //Tusk 2: Read two numbers a and b from the user
    //print the summation of all the numbers 
    //from the range [a,b]
    public static void task2(){
           
        System.out.printf("Enter two numbers: \n");
        Scanner scan = new Scanner(System.in);
        
        int x = scan.nextInt();
        int y = scan.nextInt();
        int result = 0;
        for (int i = x; i <= y; i++){
            System.out.print(i + " + ");
            result += i;
        }
        System.out.println(" = " + result);
      
    }
    
    //Task 3: Read a number n form the user
    //then read n more numbers
    //now find the average of the numbers
    public static void task3(){
        
        System.out.printf("Enter a number: \n");
        Scanner scan = new Scanner(System.in);
        
        double n = scan.nextDouble();
        double x;
        double sum = 0;
        for (int i = 0; i < n; i++){
            x = scan.nextDouble();
            sum += x;
        }
        System.out.println("Average: " + (sum/n));
    }
    
    
    //Task 3: Read a number n form the user
    //then read n more numbers
    //now find the largest distance between any pair of numbers
    public static void task4(){
        
        System.out.printf("Enter a number: \n");
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int x;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
             x = scan.nextInt();
             if (x > max)
                 max = x;
             if (x < min)
                 min = x; 
        }
        
        System.out.println("Largest distance: " + (max-min));
        
    } 
    
    
    public static void main(String[] args){
        //task1();
        //task2();
        //task3();
        task4();
    }
    
}

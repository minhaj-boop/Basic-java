/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Hello {
    
    public static void main(String[] args){
        Point p1 = new Point(2,3);
        Point p2 = new Point(-1,5);
        double distance  = p1.getDistance(p2);
        System.out.printf("%f\n", distance);
               
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Text.To.Integer;

/**
 *
 * @author HP
 */
public class TextToInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "-123456789";
        long num = convertToInteger(text);
        System.out.println(num);
    }

    private static long convertToInteger(String text) {
        long number = 0;
        if (text.charAt(0) == '-') {

            for (int i = 1; i < text.length(); i++) {
                char ch = text.charAt(i);
                int digit = ch - '0';
                number = number * 10 + digit;
            }
            number = number - (number * 2);
        } else {

            for (int i = 0; i < text.length(); i++) {
                char ch = text.charAt(i);
                int digit = ch - '0';
                number = number * 10 + digit;
            }
        }
        return number;
    }

}

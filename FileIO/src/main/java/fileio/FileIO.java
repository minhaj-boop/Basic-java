/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //readFromFile();
       // writeToFile();
        readAndWriteFromFile();
    }

    private static void readFromFile() {
        try {
            RandomAccessFile input = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\FileIO\\input.txt", "r");
            String line;

            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            
            input.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find input.txt!");
        } catch (IOException ioe) {
            System.err.println("Some IOException occured");
        }
    }

    private static void writeToFile() {
        String text = "This is some new text";
        try {
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\FileIO\\output.txt", "rw");
            //output.setLength(0); // to erase everything
            long length = output.length();
            output.seek(length);
            output.writeBytes(text + "\n");
            
            output.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find input.txt!");
        } catch (IOException ioe) {
            System.err.println("Some IOException occured");
        }
    }

    private static void readAndWriteFromFile() {
        try {
            RandomAccessFile input = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\FileIO\\input.txt", "r");
            RandomAccessFile output = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Tomal sirs java\\FileIO\\output.txt", "rw");
            
            String line;

            while (true) {
                line = input.readLine();
                if (line == null) {
                    break;
                }
                output.writeBytes(line + "\n");
            }
            
            input.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find input.txt!");
        } catch (IOException ioe) {
            System.err.println("Some IOException occured");
        }
    }

}

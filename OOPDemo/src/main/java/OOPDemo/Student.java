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
public class Student {
    
    private long studentId;
    private String studentName;
    private String address;
    private double hscGpa;
    
    // Constructor
    public Student(long studentId, String studentName, String address, double hscGpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.hscGpa = hscGpa;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getAddress() {
        return address;
    }

    public double getHscGpa() {
        return hscGpa;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}

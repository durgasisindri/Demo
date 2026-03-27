package com.MarksAverage;

import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks;

    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate overall average of all subjects
    public double overallAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return marks.length > 0 ? (double) sum / marks.length : 0;
    }

    

    public void display() {
        System.out.print(rollNo + " " + name + " ");
        for (int m : marks) System.out.print(m + " ");
        System.out.printf("(Avg: %.2f)%n", overallAverage());
    }
}

public class StudentModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3]; // small example

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter rollNo, name, 4 marks:");
            int rollNo = sc.nextInt();
            String name = sc.next();
            int[] marks = new int[4];
            for (int j = 0; j < 4; j++) marks[j] = sc.nextInt();

            students[i] = new Student(rollNo, name, marks);
        }

        System.out.println("\nAll Students:");
        for (Student s : students) s.display();

        // Find topper based on OVERALL AVERAGE
        Student topper = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].overallAverage() > topper.overallAverage()) {
                topper = students[i];
            }
        }

        System.out.println("\nTopper (Overall Average):");
        topper.display();
        System.out.printf("Overall Average: %.2f%n", topper.overallAverage());
    }
}

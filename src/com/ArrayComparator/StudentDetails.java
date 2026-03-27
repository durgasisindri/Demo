package com.ArrayComparator;

import java.util.*;
public class StudentDetails{
    public static void main(String args[]){
    	System.out.println("jk");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        sc.nextLine();
            Student students[]=new Student[size];
            for(int i=0;i<students.length;i++){
                String name=sc.nextLine();
                int id=sc.nextInt();
                int marks=sc.nextInt();
                sc.nextLine();
                students[i]=new Student(name,id,marks);
            }
            Arrays.sort(students,(s1,s2)->s1.getName().compareTo(s2.getName()));
            IO.println(Arrays.toString(students));
    }
}
class Student{
     String name;
     int id;
     int marks;
 public Student(String name,int id,int marks){
  this.name=name;
  this.id=id;
  this.marks=marks;
 }
   public String getName(){
    return name;
   }

}
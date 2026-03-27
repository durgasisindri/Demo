package com.MCQs;

import java.util.*;

public class Test {
	
    public static void main(String[] args)  {
    	Scanner sc=new Scanner(System.in);
    	int depositeBal=sc.nextInt();
    	depositeBal(depositeBal);
    	IO.println("balance have: "+getBalance(depositeBal));
    }
    public static int getBalance(int v) {
    	
    	return v;
    }
    
    public static void depositeBal(int v) {
    	System.out.println("money deposited: "+v);
    	
    }
}
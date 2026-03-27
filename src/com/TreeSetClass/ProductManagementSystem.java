package com.TreeSetClass;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

record Product(int pid, String pname) {
    public Product {
        if (pid <= 0) {
            throw new IllegalArgumentException("Product ID cannot be zero or negative. Provided: " + pid);
        }
        if (pname == null || pname.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
    }
    
    @Override
    public String toString() {
        return String.format("Product[pid=%d, pname='%s']", pid, pname);
    }
}

public class ProductManagementSystem {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("=== PRODUCT MANAGEMENT SYSTEM ===\n");
        
        // Get sorting choice from user
        System.out.println("Select sorting option:");
        System.out.println("1. Sort by PID (Ascending)");
        System.out.println("2. Sort by PID (Descending)");
        System.out.println("3. Sort by Name (Alphabetical)");
        System.out.println("4. Sort by Name (Reverse Order)");
        System.out.print("Enter your choice (1-4): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Create TreeSet with appropriate comparator
        TreeSet<Product> products = null;
        
        switch (choice) {
            case 1:
                products = new TreeSet<>(Comparator.comparingInt(Product::pid));
                System.out.println("\n--- Sorting by PID (Ascending) ---");
                break;
            case 2:
                products = new TreeSet<>(Comparator.comparingInt(Product::pid).reversed());
                System.out.println("\n--- Sorting by PID (Descending) ---");
                break;
            case 3:
                products = new TreeSet<>(Comparator.comparing(Product::pname));
                System.out.println("\n--- Sorting by Name (Alphabetical) ---");
                break;
            case 4:
                products = new TreeSet<>(Comparator.comparing(Product::pname).reversed());
                System.out.println("\n--- Sorting by Name (Reverse Order) ---");
                break;
            default:
                System.out.println("Invalid choice! Using default (PID Ascending)");
                products = new TreeSet<>(Comparator.comparingInt(Product::pid));
        }
        
        // Get products from user
        System.out.print("\nEnter number of products to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        int validProductsAdded = 0;
        
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Product " + i + " ---");
            
            System.out.print("Enter Product ID: ");
            int pid = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Product Name: ");
            String pname = scanner.nextLine();
            
            try {
                Product product = new Product(pid, pname);
                products.add(product);
                //validProductsAdded++;
                //System.out.println("Product added successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Product not added to the collection.");
            }
        }
        
        // Display results
       // System.out.println("\n" + "=".repeat(50));
        //System.out.println("FINAL OUTPUT:");
       // System.out.println("=".repeat(50));
        
        if (products.isEmpty()) {
            System.out.println("No valid products to display.");
        } else {
            //System.out.println("\nTotal products in TreeSet: " + products.size());
            //System.out.println("Valid products added: " + validProductsAdded);
            System.out.println("\nSorted Products:");
            //System.out.println("-".repeat(40));
            
            int count = 1;
            for (Product p : products) {
                System.out.println(count++ + ". " + p);
            }
        }
        
        scanner.close();
    }
}

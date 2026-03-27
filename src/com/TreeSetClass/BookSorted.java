package com.TreeSetClass;

import java.util.Scanner;
import java.util.TreeSet;

record Book(String name, String author) implements Comparable<Book> {
    
    public Book {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be null or empty");
        }
    }
    
    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("'%s' by %s", name, author);
    }
}

public class BookSorted {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Book> bookSet = new TreeSet<>();
        
        System.out.println("=== BOOK SORTING SYSTEM ===\n");
        System.out.print("Enter number of books to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Book " + i + " ---");
            
            System.out.print("Enter Book Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine();
            
            try {
                Book book = new Book(name, author);
                if (bookSet.add(book)) {
                    System.out.println("✓ Book added successfully!\n");
                } else {
                    System.out.println("⚠ Book already exists! (Duplicate based on name)\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("✗ Error: " + e.getMessage() + "\n");
            }
        }
        
        // Display sorted books
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BOOKS SORTED BY NAME (ALPHABETICAL ORDER):");
        System.out.println("=".repeat(50));
        
        if (bookSet.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            int count = 1;
            for (Book book : bookSet) {
                System.out.println(count++ + ". " + book);
            }
            System.out.println("\nTotal books: " + bookSet.size());
        }
        
        scanner.close();
    }
}

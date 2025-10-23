package com.tan.library;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager lm = new LibraryManager();
        boolean running = true;

        while(running) {
            System.out.println("1️⃣ Add book");
            System.out.println("2️⃣ Remove book");
            System.out.println("3️⃣ List all books");
            System.out.println("4️⃣ Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch(choice) {
                case "1":
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    System.out.print("ISBN: "); String isbn = sc.nextLine();
                    lm.addBook(new Book(title, author, isbn));
                    System.out.println("Book added!");
                    break;
                case "2":
                    System.out.print("ISBN to remove: "); String rmIsbn = sc.nextLine();
                    boolean removed = lm.removeBook(rmIsbn);
                    System.out.println(removed ? "Book removed!" : "Book not found!");
                    break;
                case "3":
                    lm.listBooks();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

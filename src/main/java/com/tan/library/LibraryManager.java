package com.tan.library;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryManager implements LibraryService {
    private Map<String, Book> booksMap = new HashMap<>();

    // 1️⃣ Add a new book
    @Override
    public void addBook(Book book) {
        booksMap.put(book.getIsbn(), book);
    }

    // 2️⃣ Remove book by ISBN
    @Override
    public boolean removeBook(String isbn) {
        return booksMap.remove(isbn) != null;
    }

    // 3️⃣ Update title by ISBN
    @Override
    public boolean updateBookTitle(String isbn, String newTitle) {
        return booksMap.computeIfPresent(isbn, (k, book) -> {
            book.setTitle(newTitle);
            return book;
        }) != null;
    }

    // 4️⃣ List all books
    public void listBooks() {
        List<Book> books = new ArrayList<>(booksMap.values());
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    // 5️⃣ Getter for testing later
    public List<Book> getBooks() {
        return new ArrayList<>(booksMap.values());
    }

    @Override
    public Book findBookByTitle(String title) {
        return booksMap.values().stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }

    public int countBooks() {
        return booksMap.size();

    }

    public void clearAllBooks() {
        booksMap.clear();
    }

    public List<Book> findBooksByAuthor(String author) {
        return booksMap.values().stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    public boolean hasBook(String isbn) {
        return booksMap.containsKey(isbn);
    }

    // 🧪 Quick test
    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();

        lm.addBook(new Book("Atomic Habits", "James Clear", "ISBN001"));
        lm.addBook(new Book("Clean Code", "Robert C. Martin", "ISBN002"));
        lm.listBooks();

        lm.updateBookTitle("ISBN002", "Clean Code (Updated)");
        lm.removeBook("ISBN001");

        System.out.println("\nAfter update/remove:");
        lm.listBooks();

        lm.clearAllBooks();
        System.out.println("\nList books after remove all:");
        lm.listBooks();

        lm.addBook(new Book("Atomic Habits", "James Clear", "ISBN001"));
        System.out.println("\nbook by title" + lm.findBookByTitle("Atomic Habits"));
        System.out.println("\ncount book " + lm.countBooks());
    }
}

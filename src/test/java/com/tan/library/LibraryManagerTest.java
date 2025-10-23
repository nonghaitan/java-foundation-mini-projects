package com.tan.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryManagerTest {

    @Test
    void testAddBook() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Hary Potter and Charmer of Secret", "JK Roling1", "ISBN001"));

        assertEquals(1, lm.getBooks().size());

        Book book = lm.getBooks().stream().filter(b -> b.getIsbn().equals("ISBN001")).findFirst().orElse(null);
        assertNotNull(book);
        assertEquals("Hary Potter and Charmer of Secret", book.getTitle());
        assertEquals("JK Roling1", book.getAuthor());
        assertEquals("ISBN001", book.getIsbn());

    }

    @Test
    void testRemoveBook() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Hary Potter and Charmer of Secret 2", "JK Roling2", "ISBN002"));

        boolean result = lm.removeBook("ISBN002");
        assertTrue(result);
        assertEquals(0, lm.getBooks().size());
    }

    @Test
    void testUpdateBook() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Hary Potter and Charmer of Secret 3", "JK Roling3", "ISBN003"));

        boolean result = lm.updateBookTitle("ISBN003", "Hary Potter and Charmer of Secret 3 - UPDATED");
        assertTrue(result);

        Book book = lm.getBooks().stream().filter(b -> b.getIsbn().equals("ISBN003")).findFirst().orElse(null);
        assertNotNull(book, "Book should exist after update");
        assertEquals("Hary Potter and Charmer of Secret 3 - UPDATED", book.getTitle());
    }

    @Test
    void testUpdateNonexistentBook() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author A", "ISBN001"));

        boolean result = lm.updateBookTitle("ISBN999", "No effect");
        assertFalse(result);
    }

    //Level 1
    @Test
    void testFindBookByTitle() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author A", "ISBN001"));

        Book resultFindBookByTitleA = lm.findBookByTitle("Book A");
        Book resultFindBookByTitleB = lm.findBookByTitle("Book B");
        assertEquals("Book A", resultFindBookByTitleA.getTitle());
        assertNull(resultFindBookByTitleB);

    }

    @Test
    void testCountBooks() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author A", "ISBN001"));

        assertEquals(1, lm.countBooks());
    }

    @Test
    void testClearAllBooks() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author A", "ISBN001"));

        lm.clearAllBooks();
        assertEquals(0, lm.getBooks().size());
    }

    @Test
    void testFindBooksByAuthor() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author", "ISBN001"));
        lm.addBook(new Book("Book B", "Author", "ISBN002"));

        assertEquals(2, lm.findBooksByAuthor("Author").size());
    }

    @Test
    void testHasBook() {
        LibraryManager lm = new LibraryManager();
        lm.addBook(new Book("Book A", "Author A", "ISBN001"));

        assertTrue(lm.hasBook("ISBN001"));
        assertFalse(lm.hasBook("ISBN002"));
    }
}

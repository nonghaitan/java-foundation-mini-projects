package com.tan.library;

public interface LibraryService {
    void addBook(Book book);

    boolean  removeBook(String isbn);

    boolean updateBookTitle(String isbn, String newTitle);

    Book findBookByTitle(String title);
}

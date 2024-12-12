package com.LMS.LibraryManagementsystem.Service;


import com.LMS.LibraryManagementsystem.Entity.Book;
import com.LMS.LibraryManagementsystem.Entity.User;
import com.LMS.LibraryManagementsystem.Repository.BookRepository;
import com.LMS.LibraryManagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository; // Correct repository for User

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }

    public Book borrowBook(String bookId, String userId) {
        Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;
    }

    public Book returnBook(String bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;
    }

    public Book updateBook(String id, Book book) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            // Update book fields
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setBorrowed(book.isBorrowed());
            existingBook.setBorrowedBy(book.getBorrowedBy());
            // Save updated book
            return save(existingBook);
        }
        return null;
    }
}
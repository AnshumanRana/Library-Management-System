package com.LMS.LibraryManagementsystem.Controller;



import com.LMS.LibraryManagementsystem.Entity.Book;
import com.LMS.LibraryManagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
    @PostMapping("/{bookId}/borrow/{userId}")
    public Book borrowedBy(@PathVariable String bookId,@PathVariable String userId){
        return bookService.borrowBook(bookId,userId);
    }
    @PostMapping("/{id}/return")
    public Book returnBook(@PathVariable String id){
        return bookService.returnBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
    }
}
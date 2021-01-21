package com.example.sping_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import com.example.sping_demo.exception.BookNotFoundException;
import com.example.sping_demo.model.Book;
import com.example.sping_demo.repository.BookRepository;

import java.util.List;



@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //Get All Books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    } 

    //Add Book
    @PostMapping("/books")
    public Book addBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    //Get Book by id
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value="id") Long bookId) throws BookNotFoundException{
        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }

    //Update Book by id
    @PutMapping("/book/{id}")
    public Book updateBookById(@PathVariable(value="id") Long bookId, @Valid @RequestBody Book bookDetails) throws BookNotFoundException{
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        book.setBook_name(bookDetails.getBook_name());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());
        Book updatedbook = bookRepository.save(book);
        return updatedbook;
    }

    //Delete a book
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable(value = "id") Long bookId) throws BookNotFoundException{
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}

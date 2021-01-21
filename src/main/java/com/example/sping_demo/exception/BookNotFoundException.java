package com.example.sping_demo.exception;
public class BookNotFoundException extends Exception{
    private long bookId;
    public BookNotFoundException(long bookId){
        super(String.format("Book is not found with id: '%s'.", bookId));
    }
}

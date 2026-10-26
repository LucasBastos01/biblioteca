package br.com.p2.biblioteca_api.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book not found with ID: " + id);
    }

}
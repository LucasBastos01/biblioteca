package br.com.p2.biblioteca_api.service;

import br.com.p2.biblioteca_api.dto.BookRequestDTO;
import br.com.p2.biblioteca_api.exception.BookNotFoundException;
import br.com.p2.biblioteca_api.model.Book;
import br.com.p2.biblioteca_api.repository.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book createBook(BookRequestDTO request) {

        Book book = new Book();

        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setGenre(request.genre());
        book.setPublicationYear(request.publicationYear());
        book.setReadingStatus(request.readingStatus());

        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long id) {

        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException(id)
                );
    }

    @Transactional
    public Book updateBook(Long id, BookRequestDTO request) {

        Book book = getBookById(id);

        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setGenre(request.genre());
        book.setPublicationYear(request.publicationYear());
        book.setReadingStatus(request.readingStatus());

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {

        Book book = getBookById(id);

        bookRepository.delete(book);
    }

}
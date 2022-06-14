package io.library.librarybooks.boundaries.driven.database;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.application.ports.driven.BookDataPort;
import io.library.librarybooks.boundaries.driven.database.converters.BookConverter;
import io.library.librarybooks.boundaries.driven.database.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookDataAdapter implements BookDataPort {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public BookDataAdapter(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    @Override
    public BookModel create(BookModel bookModel) {
        var book = bookRepository.save(bookConverter.convert(bookModel));
        book.setIsbn(UUID.randomUUID().toString());
        return bookConverter.convert(book);
    }

    @Override
    public BookModel get(String isbn) {
        var book = bookRepository.findByIsbn(isbn);
        return bookConverter.convert(book);
    }
}

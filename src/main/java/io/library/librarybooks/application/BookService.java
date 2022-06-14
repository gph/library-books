package io.library.librarybooks.application;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.application.ports.driven.BookDataPort;
import io.library.librarybooks.application.ports.driving.BookPort;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookPort {

    private BookDataPort bookDataPort;

    public BookService(BookDataPort bookDataPort) {
        this.bookDataPort = bookDataPort;
    }

    @Override
    public BookModel create(BookModel bookModel) {
        return bookDataPort.create(bookModel);
    }

    @Override
    public BookModel get(String isbn) {
        return null;
    }
}

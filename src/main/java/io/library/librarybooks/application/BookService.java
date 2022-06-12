package io.library.librarybooks.application;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.application.ports.driving.BookPort;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookPort {

    @Override
    public BookModel create(BookModel book) {
        return null;
    }

    @Override
    public BookModel get(String isbn) {
        return null;
    }
}

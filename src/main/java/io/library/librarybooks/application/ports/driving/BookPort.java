package io.library.librarybooks.application.ports.driving;

import io.library.librarybooks.application.models.BookModel;

public interface BookPort {
    BookModel create(BookModel book);
    BookModel get(String isbn);
}

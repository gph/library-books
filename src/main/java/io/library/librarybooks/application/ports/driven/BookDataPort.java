package io.library.librarybooks.application.ports.driven;

import io.library.librarybooks.application.models.BookModel;

public interface BookDataPort {
    BookModel create(BookModel bookModel);
    BookModel get(String isbn);
}

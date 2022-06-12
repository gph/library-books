package io.library.librarybooks.boundaries.driving.controllers.converters;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.boundaries.driving.controllers.models.BookApiModel;
import org.springframework.stereotype.Component;

@Component
public class BookApiModelConverter {
    public BookModel convert(BookApiModel bookApiModel){
        BookModel book = new BookModel();
        book.setId(bookApiModel.getId());
        book.setIsbn(bookApiModel.getIsbn());
        return book;
    }

    public BookApiModel convert(BookModel book){
        var bookApiModel = new BookApiModel();
        book.setId(book.getId());
        book.setIsbn(book.getIsbn());
        return bookApiModel;
    }
}

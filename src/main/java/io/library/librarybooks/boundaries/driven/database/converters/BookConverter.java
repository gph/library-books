package io.library.librarybooks.boundaries.driven.database.converters;

import io.library.librarybooks.application.models.BookModel;

import io.library.librarybooks.boundaries.driven.database.models.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public BookModel convert(Book book){
        BookModel bookModel = new BookModel();
        bookModel.setId(book.getId());
        bookModel.setIsbn(book.getIsbn());
        return bookModel;
    }

    public Book convert(BookModel bookModel){
        var book = new Book();
        book.setId(bookModel.getId());
        book.setIsbn(bookModel.getIsbn());
        return book;
    }
}

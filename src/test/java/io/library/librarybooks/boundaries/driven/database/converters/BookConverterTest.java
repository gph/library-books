package io.library.librarybooks.boundaries.driven.database.converters;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.boundaries.driven.database.models.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookConverterTest {
    private BookConverter bookConverter = new BookConverter();

    @Test
    void convert_shouldReturnBookModel_whenSuccessful() {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setIsbn(UUID.randomUUID().toString());

        var bookModel = bookConverter.convert(book);

        assertEquals(book.getId(), bookModel.getId());
        assertEquals(book.getIsbn(), bookModel.getIsbn());
    }

    @Test
    void convert_shouldReturnBook_whenSuccessful() {
        BookModel bookModel = new BookModel();
        bookModel.setId(UUID.randomUUID().toString());
        bookModel.setIsbn(UUID.randomUUID().toString());

        var book = bookConverter.convert(bookModel);

        assertEquals(bookModel.getId(), book.getId());
        assertEquals(bookModel.getIsbn(), book.getIsbn());
    }
}

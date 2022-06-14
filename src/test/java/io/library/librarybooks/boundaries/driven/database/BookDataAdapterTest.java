package io.library.librarybooks.boundaries.driven.database;

import io.library.librarybooks.application.models.BookModel;
import io.library.librarybooks.boundaries.driven.database.converters.BookConverter;
import io.library.librarybooks.boundaries.driven.database.models.Book;
import io.library.librarybooks.boundaries.driven.database.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BookDataAdapterTest {

    @InjectMocks
    private BookDataAdapter bookDataAdapter;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookConverter bookConverter;

    @Test
    void create_shouldReturnBookModel_whenSuccessful(){
        var bookModel = new BookModel();
        var book = new Book();
        var bookSaved = new Book();
        bookSaved.setId(UUID.randomUUID().toString());
        var bookModelUpdated = new BookModel();
        bookModelUpdated.setId(UUID.randomUUID().toString());

        Mockito.when(bookConverter.convert(bookModel)).thenReturn(book);
        Mockito.when(bookRepository.save(book)).thenReturn(bookSaved);
        Mockito.when(bookConverter.convert(bookSaved)).thenReturn(bookModelUpdated);

        var response = bookDataAdapter.create(bookModel);

        assertEquals(bookModelUpdated.getId(), response.getId());
    }

    @Test
    void create_shouldReturnIsbnNotNull_whenSuccessful(){
        var bookModel = new BookModel();
        var book = new Book();
        var bookSaved = new Book();
        bookSaved.setId(UUID.randomUUID().toString());

        Mockito.when(bookConverter.convert(bookModel)).thenReturn(book);
        Mockito.when(bookRepository.save(book)).thenReturn(bookSaved);
        //Mockito.when(bookConverter.convert(bookSaved)).thenCallRealMethod();

        Mockito.doAnswer(invocation -> {
            Book bookParam = invocation.getArgument(0);
            assertNotNull(bookParam.getIsbn());

            return bookModel;
        }).when(bookConverter).convert(any(Book.class));

        bookDataAdapter.create(bookModel);

    }
}

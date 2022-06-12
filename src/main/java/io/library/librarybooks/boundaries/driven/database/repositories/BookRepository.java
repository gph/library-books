package io.library.librarybooks.boundaries.driven.database.repositories;

import io.library.librarybooks.boundaries.driven.database.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);
}

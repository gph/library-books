package io.library.librarybooks.boundaries.driving.controllers;

import io.library.librarybooks.application.ports.driving.BookPort;
import io.library.librarybooks.boundaries.driving.controllers.converters.BookApiModelConverter;
import io.library.librarybooks.boundaries.driving.controllers.models.BookApiModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookPort bookPort;
    private final BookApiModelConverter bookApiModelConverter;

    public BookController(BookPort bookPort, BookApiModelConverter bookApiModelConverter) {
        this.bookPort = bookPort;
        this.bookApiModelConverter = bookApiModelConverter;
    }

    @PostMapping()
    public BookApiModel create(@RequestBody BookApiModel bookApiModel){
        var response = bookPort.create(bookApiModelConverter.convert(bookApiModel));
        return bookApiModelConverter.convert(response);
    }
}

package io.library.librarybooks.boundaries.driving.controllers.models;

public class BookApiModel {
    private String id;
    private String isbn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

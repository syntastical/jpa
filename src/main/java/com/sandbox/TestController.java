package com.sandbox;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;

@Secured({"admin"})
@Controller
public class TestController {

    BookRepository bookRepository;
    StoreRepository storeRepository;

    public TestController(
            BookRepository bookRepository,
            StoreRepository storeRepository
    ) {
        this.bookRepository = bookRepository;
        this.storeRepository = storeRepository;
    }

    @Get("/book/{id}")
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Post("/book/{name}")
    public Book saveBook(String name) {
        return bookRepository.save(name);
    }

    @Delete("/book/{id}")
    public void delete(Long id) {

    }

    @Post("/store")
    public Store saveBook() {
        Store store = new Store("Walmart");
        Book book = new Book("Book1");
        book.setStore(store);
        Book book2 = new Book("Book2");
        book2.setStore(store);

        return storeRepository.save(store);
    }

    @Delete("book")
    public void delete() {
        bookRepository.deleteAll();
    }
}

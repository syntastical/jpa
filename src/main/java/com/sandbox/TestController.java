package com.sandbox;

import io.micronaut.http.annotation.*;

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

    @Get("{id}")
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Post("/{name}")
    public Book saveBook(String name) {
        return bookRepository.save(name);
    }

    @Delete("/{id}")
    public void delete(Long id) {

    }

    @Post("/store")
    public Store saveBook() {
        Store store = new Store("Walmart");
        Book book = new Book("Book1");
        store.getBook().add(book);
        Book book2 = new Book("Book2");
        store.getBook().add(book2);

        return storeRepository.save(store);
    }
}

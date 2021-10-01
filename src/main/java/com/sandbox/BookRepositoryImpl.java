package com.sandbox;

import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Singleton
public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager;

    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ReadOnly
    public Optional<Book> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    @Transactional
    public Book save(@NotBlank String name) {
        Book book = new Book(name);
        entityManager.persist(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        Book book = this.findById(1L).get();
        entityManager.remove(book);
    }

}

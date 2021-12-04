package com.sandbox;

import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        book.setIsdn(UUID.randomUUID());
        entityManager.persist(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        Book book = this.findById(1L).get();
        entityManager.remove(book);
    }

    @Override
    @Transactional
    public void deleteAll() {
        String deleteSql = "delete from Book";
        Query query = entityManager.createQuery(deleteSql);
        System.out.println(query.executeUpdate());
    }
}

package com.sandbox;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(@NotNull Long id);
    Book save(@NotBlank String name);
    void delete(@NotNull Long id);
    void deleteAll();
}

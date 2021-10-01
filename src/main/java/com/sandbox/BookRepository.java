package com.sandbox;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(@NotNull Long id);
    Book save(@NotBlank String name);
    void delete(@NotNull Long id);
}

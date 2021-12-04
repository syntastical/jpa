package com.sandbox;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(@NotNull Long id);
    Optional<User> findByUsername(@NotNull String username);
    User save(@NotBlank User user);
    void delete(@NotNull Long id);
}

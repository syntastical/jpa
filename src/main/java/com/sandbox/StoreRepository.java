package com.sandbox;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface StoreRepository {
    Store save(@NotBlank Store store);
}

package com.sandbox;

import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Singleton
public class StoreRepositoryImpl implements StoreRepository {
    private final EntityManager entityManager;

    public StoreRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Store save(@NotBlank Store store) {
        entityManager.persist(store);
        return store;
    }


}

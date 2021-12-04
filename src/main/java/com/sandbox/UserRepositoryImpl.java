package com.sandbox;

import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.hibernate.bytecode.internal.bytebuddy.HibernateMethodLookupDispatcher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @ReadOnly
    public Optional<User> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }
    @ReadOnly
    public Optional<User> findByUsername(@NotNull String username) {
        String sql = "select u from User u where username = :username";
        Query query = entityManager.createQuery(sql);
        query.setParameter("username", username);

        return Optional.ofNullable((User) query.getSingleResult());
    }

    @Override
    @Transactional
    public User save(@NotBlank User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = this.findById(id).get();
        entityManager.remove(user);
    }

//    @Override
//    @Transactional
//    public void deleteAll() {
//        String deleteSql = "delete from Book";
//        Query query = entityManager.createQuery(deleteSql);
//        System.out.println(query.executeUpdate());
//    }
}

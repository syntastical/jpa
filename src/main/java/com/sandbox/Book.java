package com.sandbox;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table(name = "book")
public class Book {

    public Book() {}

    public Book(@NotNull String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
//    @Column(name = "fk_store", nullable = false)
    @ManyToOne(targetEntity = Store.class)
    private Store store;

    private UUID isdn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        store.getBook().add(this);
        this.store = store;
    }

    public UUID getIsdn() {
        return isdn;
    }

    public void setIsdn(UUID isdn) {
        this.isdn = isdn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
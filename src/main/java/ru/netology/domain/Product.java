package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

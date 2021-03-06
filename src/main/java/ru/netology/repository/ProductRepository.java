package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] items = new Product[0];

    //сохраняем
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //получение
    public Product[] findAll() {
        return items;
    }

}

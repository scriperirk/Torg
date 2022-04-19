package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);

    private Product book1 = new Book(21, "Тестирование Дот Ком", 2000, "Роман Савин");
    private Product book2 = new Book(25, "Software testing", 1500, "Рон Паттон");
    private Product phone1 = new Smartphone(30, "C25s", 65000, "Realme");
    private Product phone2 = new Smartphone(35, "Galaxy S9plus", 45000, "Samsung");
    private Product product1 = new Product(7, "None", 100);

    @BeforeEach
    void setUp() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(product1);
        manager.add(phone2);
        manager.add(book2);
    }

    //проверка несуществующего
    @Test
    void searchByNotFound() {
        Product[] actual = manager.searchBy("Чудеса");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

    //поиск автора
    @Test
    void searchByAuthorBook() {
        Product[] actual = manager.searchBy("Роман Савин");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    //поиск наименования
    @Test
    void searchByNameBook() {
        Product[] actual = manager.searchBy("Software testing");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    //поиск названия модели
    @Test
    void searchByNamePhone() {
        Product[] actual = manager.searchBy("Galaxy S9plus");
        Product[] expected = new Product[]{phone2};

        assertArrayEquals(expected, actual);
    }

    //поиск по фирме
    @Test
    void searchByManufacturerPhone() {
        Product[] actual = manager.searchBy("Realme");
        Product[] expected = new Product[]{phone1};

        assertArrayEquals(expected, actual);
    }

}
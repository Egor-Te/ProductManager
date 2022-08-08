package ru.netology.Product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1,"Book1", 100, "Irina");
    Book book2 = new Book(2,"Book2", 200, "Egor");
    Book book3 = new Book(3,"Magazine3", 300, "Sasha");

    Product product1 = new Product(5, "Product1", 400);
    Product product2 = new Product(6, "Product2", 500);
    Product product3 = new Product(7, "Product3", 600);

    Smartphone smartphone1 = new Smartphone(10, "Smartphone1", 700, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(11, "Smartphone2", 800, "Manufacturer1");
    Smartphone smartphone3 = new Smartphone(12, "Smartphone3", 900, "Manufacturer2");


    @Test
    public void shouldNameProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { product3};
        Product[] actual = manager.searchBy("Product3");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void addBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addSmartphone() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = { smartphone1, smartphone2, smartphone3 };
        Product[] actual = manager.repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindAuthor() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Grisha");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindIDSmartphone() {

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("333");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findOneAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Slava");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNameBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Book");
        Product[] expected = { book1, book2 };

        assertArrayEquals(expected, actual);

    }


    @Test
    public void findOneNameBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Magazine");
        Product[] expected = { book3 };

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindBook() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Kniga");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindId() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("4");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void findId() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("2");
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindPrice() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("400");
        Product[] expected = {};

        assertArrayEquals(expected, actual);

    }

}





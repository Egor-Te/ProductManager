package ru.netology.Product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Book book1 = new Book(1, "Book1", 100, "Irina");
    Book book2 = new Book(2, "Book2", 200, "Egor");
    Book book3 = new Book(3, "Magazine3", 300, "Sasha");

    Product product1 = new Product(5, "Product1", 400);
    Product product2 = new Product(6, "Product2", 500);
    Product product3 = new Product(7, "Product3", 600);


    @Test
    public void RemoveByIDProduct() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repository.getProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveByIDBook() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        repository.removeById(book2.getId());

        Product[] expected = {book1, book3};
        Product[] actual = repository.getProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void FindAllProducts() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void AddProducts() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.products;

        assertArrayEquals(expected, actual);

    }

}

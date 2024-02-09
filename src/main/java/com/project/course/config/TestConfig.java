package com.project.course.config;

import com.project.course.entities.Category;
import com.project.course.entities.Order;
import com.project.course.entities.Product;
import com.project.course.entities.User;
import com.project.course.entities.enums.OrderStatus;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.OrderRepository;
import com.project.course.repositories.ProductRepository;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(null, "Iphone", "this is a great device!", 950.0, "");
        Product p2 = new Product(null, "Jetta tsi", "jetta 2015 2.0!", 80000.0, "");
        Product p3 = new Product(null, "GOLF GTI", "my big dream 🙏!", 130000.0, "");
        Product p4 = new Product(null, "992 911 CARRERA", "my big dream after GOLF 🙏!", 2000000.0, "");
        Product p5 = new Product(null, "LAMBORGHINI", "this is a big big dream🙏!", 6000000.0, "");

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
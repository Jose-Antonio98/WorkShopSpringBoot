package edu.joseph.course.config;

import edu.joseph.course.entites.*;
import edu.joseph.course.entites.enums.OrderStatus;
import edu.joseph.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration // anotação spring para adicionar uma configuração
@Profile("test") // anotação spring para adicionar um nome ao perfil
public class TestConfig implements CommandLineRunner {

    @Autowired // anotação spring para fazer uma injeção de dependencia
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        var o1 = new Order(null, Instant.parse("2023-01-20T19:53:07Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        var o3 = new Order(null, Instant.parse("2023-04-22T15:21:22Z"), OrderStatus.PAID, u1);

        var cat1 = new Category(null, "Electronics");
        var cat2 = new Category(null, "Books");
        var cat3 = new Category(null, "Computers");

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        var oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        var oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        var oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        var oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }


}

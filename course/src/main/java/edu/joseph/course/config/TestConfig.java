package edu.joseph.course.config;

import edu.joseph.course.entites.Order;
import edu.joseph.course.entites.User;
import edu.joseph.course.repositories.OrderRepository;
import edu.joseph.course.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        var o1 = new Order(null, Instant.parse("2023-01-20T19:53:07Z"), u1);
        var o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), u2);
        var o3 = new Order(null, Instant.parse("2023-04-22T15:21:22Z"), u1);
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}

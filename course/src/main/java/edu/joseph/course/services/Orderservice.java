package edu.joseph.course.services;

import edu.joseph.course.entites.Order;
import edu.joseph.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Orderservice {

    @Autowired
    private OrderRepository repository;

    public List<Order> findALl() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional <Order> obj = repository.findById(id);
        return obj.get();
    }
}

package edu.joseph.course.resources;

import edu.joseph.course.entites.Order;
import edu.joseph.course.services.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    private Orderservice orderservice;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> allUsers = orderservice.findALl();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        var obj = orderservice.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

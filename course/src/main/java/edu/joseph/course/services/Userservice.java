package edu.joseph.course.services;

import edu.joseph.course.entites.User;
import edu.joseph.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    private UserRepository repository;

    public List<User> findALl() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional <User> obj = repository.findById(id);
        return obj.get();
    }
}

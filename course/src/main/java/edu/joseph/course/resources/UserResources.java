package edu.joseph.course.resources;

import edu.joseph.course.entites.User;
import edu.joseph.course.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private Userservice userservice;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> allUsers = userservice.findALl();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var obj = userservice.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

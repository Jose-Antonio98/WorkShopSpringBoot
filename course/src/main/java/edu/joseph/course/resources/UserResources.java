package edu.joseph.course.resources;

import edu.joseph.course.entites.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        var user = new User(1L, "Maria", "maria@gmail.com", "888888888", "123456");
        return ResponseEntity.ok().body(user);
    }
}

package edu.joseph.course.resources;

import edu.joseph.course.entites.Category;
import edu.joseph.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @Autowired
    private CategoryService categoryservice;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> allCategories = categoryservice.findALl();
        return ResponseEntity.ok().body(allCategories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        var obj = categoryservice.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

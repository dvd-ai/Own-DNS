package com.example.secutitytest.Controllers;


import com.example.secutitytest.Entity.Developer;
import com.example.secutitytest.Services.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/developers")
public class DevController {
@Autowired
    DevService service;

    @GetMapping
    @PreAuthorize("")
    public ResponseEntity<?> getAll(){
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }


    @PostMapping
    public Developer create(@RequestBody Developer developer){
        service.save(developer);

        return developer;
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  Long id){
        service.delete(id);
    }
}

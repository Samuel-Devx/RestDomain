package com.apiRest.nuvem.RestDomain.Controller;

import com.apiRest.nuvem.RestDomain.Model.User;
import com.apiRest.nuvem.RestDomain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControler {

    private final UserService service;

    public UserControler(UserService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userCreate = service.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(userCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreate);
    }

    @GetMapping("/all")
    public ResponseEntity<List> findAll(){
        return ResponseEntity.ok(service.findAll());
    }





}

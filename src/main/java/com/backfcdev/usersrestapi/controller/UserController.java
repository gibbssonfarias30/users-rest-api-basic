package com.backfcdev.usersrestapi.controller;

import com.backfcdev.usersrestapi.model.User;
import com.backfcdev.usersrestapi.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    @GetMapping
    ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> findUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user){
        return new ResponseEntity<>(userService.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> deleteUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}

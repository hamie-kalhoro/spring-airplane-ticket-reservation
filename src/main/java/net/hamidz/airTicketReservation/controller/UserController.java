package net.hamidz.airTicketReservation.controller;

import net.hamidz.airTicketReservation.entity.User;
import net.hamidz.airTicketReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;
    @Autowired public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User userById = userService.findUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.FOUND);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        User user = userService.findUserById(id);
        if(user != null && !user.equals("")) {
            user.setUsername(user.getUsername() != null && !user.getUsername().isEmpty()
                    ? newUser.getUsername() : user.getUsername());
            user.setPassword(user.getPassword() != null && !user.getPassword().isEmpty()
                    ? newUser.getPassword() : user.getPassword());
            userService.createUser(user);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

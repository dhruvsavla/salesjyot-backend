package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.User;
import com.example.warehousegenius.Service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        if(user != null){
            Map<String, String> response = new HashMap<>();
            response.put(user.getUserName(), "Login successful");
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.status(401).body("Invalid email or password!");
        }
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findByEmailAndPassword")
    public ResponseEntity<User> findByEmailAndPassword(
            @RequestParam String email,
            @RequestParam String password) {
        User user = userService.findByEmailAndPassword(email, password);
        if (user == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(user);
    }
}


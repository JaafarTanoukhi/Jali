package com.jali.endpoints.Auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private List<Integer> authData = new ArrayList<>();

    // Create a new auth record
    @PostMapping
    public ResponseEntity<SingnupResponse> createAuth(@RequestBody SignupBody auth ) {
        // authData.add(auth);
        return ResponseEntity.ok(new SingnupResponse());
    }

    // Get all auth records
    @GetMapping
    public ResponseEntity<List<Integer>> getAllAuths() {
        return new ResponseEntity<>(authData, HttpStatus.OK);
    }

    // Get a single auth record by ID (index)
    @GetMapping("/{id}")
    public ResponseEntity<Integer> getAuthById(@PathVariable int id) {
        if (id >= 0 && id < authData.size()) {
            return new ResponseEntity<>(authData.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an auth record by ID (index)
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateAuth(@PathVariable int id, @RequestBody Integer newAuth) {
        if (id >= 0 && id < authData.size()) {
            authData.set(id, newAuth);
            return new ResponseEntity<>(newAuth, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an auth record by ID (index)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuth(@PathVariable int id) {
        if (id >= 0 && id < authData.size()) {
            authData.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

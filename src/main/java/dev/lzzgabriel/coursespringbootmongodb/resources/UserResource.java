package dev.lzzgabriel.coursespringbootmongodb.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lzzgabriel.coursespringbootmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  
  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    var u1 = new User("1", "Maria", "maria@gmail.com");
    var u2 = new User("2", "Alex", "alex@gmail.com");
    return ResponseEntity.ok(List.of(u1, u2));
  }

}

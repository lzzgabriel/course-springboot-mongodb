package dev.lzzgabriel.coursespringbootmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lzzgabriel.coursespringbootmongodb.dto.UserDTO;
import dev.lzzgabriel.coursespringbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    var users = service.findAll()
        .stream()
        .map(user -> new UserDTO(user))
        .collect(Collectors.toList());
    return ResponseEntity.ok(users);
  }

}

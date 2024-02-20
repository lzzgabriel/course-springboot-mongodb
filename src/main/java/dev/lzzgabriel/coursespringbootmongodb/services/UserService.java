package dev.lzzgabriel.coursespringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.coursespringbootmongodb.domain.User;
import dev.lzzgabriel.coursespringbootmongodb.repository.UserRepository;
import dev.lzzgabriel.coursespringbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }
  
  public User findById(String id) {
    var user = repository.findById(id);
    return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

}

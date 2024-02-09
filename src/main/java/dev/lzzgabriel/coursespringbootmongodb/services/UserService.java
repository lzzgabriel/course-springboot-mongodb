package dev.lzzgabriel.coursespringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.coursespringbootmongodb.domain.User;
import dev.lzzgabriel.coursespringbootmongodb.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;
  
  public List<User> findAll() {
    return repository.findAll();
  }

}

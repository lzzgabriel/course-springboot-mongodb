package dev.lzzgabriel.coursespringbootmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.coursespringbootmongodb.domain.Post;
import dev.lzzgabriel.coursespringbootmongodb.repository.PostRepository;
import dev.lzzgabriel.coursespringbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
  
  @Autowired
  private PostRepository repository;
  
  public Post findById(String id) {
    return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

}

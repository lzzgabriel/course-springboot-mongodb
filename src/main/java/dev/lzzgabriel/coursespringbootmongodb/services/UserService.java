package dev.lzzgabriel.coursespringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lzzgabriel.coursespringbootmongodb.domain.User;
import dev.lzzgabriel.coursespringbootmongodb.dto.UserDTO;
import dev.lzzgabriel.coursespringbootmongodb.repository.UserRepository;
import dev.lzzgabriel.coursespringbootmongodb.services.exceptions.ObjectNotFoundException;

/**
 * As classes de serviço são as que contém as regras de negócio. Use @Service
 * nas que forem cumprir esse papel.
 */
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

  public User insert(User obj) {
    return repository.insert(obj);
  }

  public void delete(String id) {
    findById(id);
    repository.deleteById(id);
  }

  public User update(User obj) {
    var newObj = repository.findById(obj.getId())
        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    updateData(newObj, obj);
    return repository.save(newObj);
  }

  private void updateData(User newObj, User obj) {
    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());
  }

  public User fromDTO(UserDTO objDTO) {
    return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
  }

}

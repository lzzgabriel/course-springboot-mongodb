package dev.lzzgabriel.coursespringbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import dev.lzzgabriel.coursespringbootmongodb.domain.Post;

/**
 * O Spring Boot cria automaticamente a instância dessa interface para realizar
 * as operações. Basta incluir a interface onde ela for usada e injetá-la.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  
  @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);
  
  List<Post> findByTitleContainingIgnoreCase(String text);
  
}

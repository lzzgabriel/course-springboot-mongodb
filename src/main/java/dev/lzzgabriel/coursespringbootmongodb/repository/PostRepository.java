package dev.lzzgabriel.coursespringbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.lzzgabriel.coursespringbootmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}

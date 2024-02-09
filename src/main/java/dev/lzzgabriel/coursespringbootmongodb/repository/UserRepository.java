package dev.lzzgabriel.coursespringbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.lzzgabriel.coursespringbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}

package dev.lzzgabriel.coursespringbootmongodb.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import dev.lzzgabriel.coursespringbootmongodb.domain.Post;
import dev.lzzgabriel.coursespringbootmongodb.domain.User;
import dev.lzzgabriel.coursespringbootmongodb.dto.AuthorDTO;
import dev.lzzgabriel.coursespringbootmongodb.repository.PostRepository;
import dev.lzzgabriel.coursespringbootmongodb.repository.UserRepository;

/**
 * As classes @Configuration são rodadas pelo Spring Boot ao iniciar a
 * aplicação, no caso, a CommandLineRunner executa códigos assim que é startado
 * o app no método {@link #run(String...)}.
 */
@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    userRepository.saveAll(List.of(maria, alex, bob));

    Post post1 = new Post(null, LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2023-03-21T12:01:05"))
        .toInstant(ZoneOffset.UTC), "Partiu viagem", "Vou viajar para São Paulo, abs!", new AuthorDTO(maria));
    Post post2 = new Post(null, LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2023-03-23T08:32:12"))
        .toInstant(ZoneOffset.UTC), "Bom dia!", "Acordei feliz hoje", new AuthorDTO(maria));

    postRepository.saveAll(List.of(post1, post2));

    maria.getPosts().addAll(List.of(post1, post2));
    userRepository.save(maria);
  }

}

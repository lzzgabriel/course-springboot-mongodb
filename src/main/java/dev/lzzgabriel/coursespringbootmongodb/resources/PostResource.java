package dev.lzzgabriel.coursespringbootmongodb.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lzzgabriel.coursespringbootmongodb.domain.Post;
import dev.lzzgabriel.coursespringbootmongodb.resources.util.URL;
import dev.lzzgabriel.coursespringbootmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
  
  @Autowired
  private PostService service;
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    var obj = service.findById(id);
    return ResponseEntity.ok(obj);
  }
  
  @GetMapping(value = "/titlesearch")
  public ResponseEntity<List<Post>> findByTitle(@RequestParam String text) {
    text = URL.decodeParam(text);
    var objs = service.findByTitle(text);
    return ResponseEntity.ok(objs);
  }
  
  @GetMapping(value = "/fullsearch")
  public ResponseEntity<List<Post>> fullSearch(@RequestParam String text, @RequestParam(required = false) String minMoment, @RequestParam(required = false) String maxMoment) {
    text = URL.decodeParam(text);
    var now = Instant.now();
    var min = URL.convertInstant(minMoment, now);
    var max = URL.convertInstant(maxMoment, now);
    var objs = service.fullSearch(text, min, max);
    return ResponseEntity.ok(objs);
  }

}

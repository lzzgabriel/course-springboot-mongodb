package dev.lzzgabriel.coursespringbootmongodb.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.lzzgabriel.coursespringbootmongodb.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
  
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
    var err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), req.getRequestURI());
    return ResponseEntity.status(err.getStatus()).body(err);
  }

}

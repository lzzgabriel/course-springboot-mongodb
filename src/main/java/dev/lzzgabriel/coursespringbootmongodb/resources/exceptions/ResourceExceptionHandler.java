package dev.lzzgabriel.coursespringbootmongodb.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.lzzgabriel.coursespringbootmongodb.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Até agora (28/2/2024) só usei a @ControllerAdvice para configurar
 * ExceptionHandlers
 */
@ControllerAdvice
public class ResourceExceptionHandler {

  /**
   * Toda vez que o código estourar uma exceção do tipo especificado (sem ser
   * tratada lá dentro, obviamente), ele cai aqui e executa o que tiver
   */
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
    var err = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(),
        req.getRequestURI());
    return ResponseEntity.status(err.getStatus()).body(err);
  }

}

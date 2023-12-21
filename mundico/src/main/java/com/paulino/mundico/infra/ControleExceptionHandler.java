package com.paulino.mundico.infra;

import com.paulino.mundico.DTO.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControleExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> empDuplicationEntry( DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Empilhadeira já cadastrada", "Erro 400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> threatGeneralException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(),"500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}

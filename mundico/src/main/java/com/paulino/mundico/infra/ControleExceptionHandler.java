package com.paulino.mundico.infra;

import com.paulino.mundico.DTO.ExceptionDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControleExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> empDuplicationEntry( DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Empilhadeira já cadastrada", "Erro 400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}

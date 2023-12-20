package com.paulino.mundico.controlles;

import com.paulino.mundico.DTO.EmpilhadeiraDTO;
import com.paulino.mundico.domain.Empilhadeira;
import com.paulino.mundico.services.EmpilhadeiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empilhadeira")
public class EmpilhadeiraController {

    @Autowired
    private EmpilhadeiraService empService;

    @PostMapping
    public ResponseEntity<Empilhadeira> create(@RequestBody EmpilhadeiraDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empService.createEmp(dto));
    }

    @GetMapping
    public ResponseEntity<List<Empilhadeira>> listAllEmpilhadeira(){
        return ResponseEntity.status(HttpStatus.OK).body(empService.getAllEmpilhadeira());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empilhadeira> getEmpilhadeira(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(empService.findEmpId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empilhadeira> updateEmpilhadeira(@PathVariable Long id, @RequestBody EmpilhadeiraDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(empService.updateEmp(id, dto));
    }

}

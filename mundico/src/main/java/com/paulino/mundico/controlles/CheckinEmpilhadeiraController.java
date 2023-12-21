package com.paulino.mundico.controlles;

import com.paulino.mundico.DTO.CheckinEmpDTO;
import com.paulino.mundico.domain.CheckinEmpilhadeira;
import com.paulino.mundico.services.ChekinEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklistEmp")
public class CheckinEmpilhadeiraController {

    @Autowired
    private ChekinEmpService chekinEmpService;

    @GetMapping
    public ResponseEntity<List<CheckinEmpilhadeira>> getAllCheckEmp() {
        return ResponseEntity.status(HttpStatus.OK).body(chekinEmpService.lisCheckinEmp());
    }

    @PostMapping
    public ResponseEntity<CheckinEmpilhadeira> novoCheckEmp(@RequestBody CheckinEmpDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(chekinEmpService.createCheckEmp(dto));

    }
}

package com.example.mundico.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mundico.DTO.EmpilhadeiraRecordDTO;
import com.example.mundico.models.EmpilhadeiraModel;
import com.example.mundico.services.EmpilhadeiraService;

import jakarta.validation.Valid;

@RestController()
public class EmpilhadeiraController {

	@Autowired
	private EmpilhadeiraService empService;

	@GetMapping("/empilhadeira")
	public ResponseEntity<List<EmpilhadeiraModel>> getAllEmpilhadeira() {
		return ResponseEntity.status(HttpStatus.OK).body(empService.list());

	}

	@GetMapping("/empilhadeira/{id}")
	public ResponseEntity<Object> getByIdEmpilhadeira(@PathVariable UUID id) {
		Optional<EmpilhadeiraModel> empOptinal = empService.findById(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}

		return ResponseEntity.status(HttpStatus.OK).body(empOptinal.get());

	}

	@PostMapping("/empilhadeira")
	public ResponseEntity<EmpilhadeiraModel> saveEmpilhadeira(@RequestBody @Valid EmpilhadeiraRecordDTO empDTO) {
		var empModel = new EmpilhadeiraModel();
		BeanUtils.copyProperties(empDTO, empModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.salvar(empModel));
	}

	@PutMapping("/empilhadeira/{id}")
	public ResponseEntity<Object> updateEmpilhadeira(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid EmpilhadeiraRecordDTO empDTO) {

		Optional<EmpilhadeiraModel> empOptinal = empService.findById(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}

		var empModel = empOptinal.get();
		BeanUtils.copyProperties(empDTO, empModel);
		return ResponseEntity.status(HttpStatus.OK).body(empService.salvar(empModel));

	}

	@DeleteMapping("/empilhadeira/{id}")
	public ResponseEntity<Object> deleteEmpilhadeira(@PathVariable(value = "id") UUID id) {

		Optional<EmpilhadeiraModel> empOptinal = empService.findById(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}
		empService.delete(empOptinal.get());
		return ResponseEntity.status(HttpStatus.OK).body("Successfully");
	}

}

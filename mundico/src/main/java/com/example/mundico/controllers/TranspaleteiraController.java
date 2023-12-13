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

import com.example.mundico.DTO.TranspaleteiraRecordDTO;
import com.example.mundico.models.TranspaleteiraModel;
import com.example.mundico.services.TranspaleteiraService;

import jakarta.validation.Valid;

@RestController
public class TranspaleteiraController {

	@Autowired
	private TranspaleteiraService tranService;

	@GetMapping("/transpaleteira")
	public ResponseEntity<List<TranspaleteiraModel>> listTranspaleteira() {
		return ResponseEntity.status(HttpStatus.OK).body(tranService.listAllTranspareteira());
	}

	@GetMapping("/transpaleteira/{id}")
	public ResponseEntity<Object> findByTranspaleteira(@PathVariable UUID id) {

		Optional<TranspaleteiraModel> optional = tranService.findByTranspaleteira(id);
		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}

		return ResponseEntity.status(HttpStatus.OK).body(optional.get());

	}

	@PostMapping("/transpaleteira")
	public ResponseEntity<TranspaleteiraModel> saveTranspaleteira(@RequestBody @Valid TranspaleteiraRecordDTO traDTO) {
		
		var traModel = new TranspaleteiraModel();
		BeanUtils.copyProperties(traDTO, traModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tranService.createTranspaleteira(traModel));

	}

	@PutMapping("/transpaleteira/{id}")
	public ResponseEntity<Object> updateTranspaleteira(@PathVariable(value = "id") UUID id,
			@RequestBody TranspaleteiraRecordDTO traDTO) {

		Optional<TranspaleteiraModel> optional = tranService.findByTranspaleteira(id);

		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
		
		var empModel = optional.get();
		BeanUtils.copyProperties(traDTO, empModel);
		
		return ResponseEntity.status(HttpStatus.OK).body(tranService.createTranspaleteira(empModel));

	}
	
	@DeleteMapping("/transpaleteira/{id}")
	public ResponseEntity<Object> deleteTranspaleteira(@PathVariable(value = "id") UUID id){
		
		Optional<TranspaleteiraModel> optional = tranService.findByTranspaleteira(id);
		
		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		}
		
		tranService.deleteTranspaleteira(optional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Successfully");

	}

}

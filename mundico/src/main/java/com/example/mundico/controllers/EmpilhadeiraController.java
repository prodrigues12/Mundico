package com.example.mundico.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mundico.DTO.EmpilhadeiraRecordDTO;
import com.example.mundico.models.EmpilhadeiraModel;
import com.example.mundico.repositories.EmpilhadeiraRepository;
import com.example.mundico.services.EmpilhadeiraService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empilhadeira")
public class EmpilhadeiraController {

	@Autowired
	private EmpilhadeiraService empService;

	@Autowired
	EmpilhadeiraRepository empRepository;

	@GetMapping
	public ResponseEntity<List<EmpilhadeiraModel>> getAllEmpilhadeiras() {

		List<EmpilhadeiraModel> list = empService.list();
		if(!list.isEmpty()) {
			for (EmpilhadeiraModel empilhadeira : list) {
				UUID id = empilhadeira.getIdEmpilhadeira();
				empilhadeira.add(linkTo(methodOn(EmpilhadeiraController.class).getByIdEmpilhadeira(id)).withSelfRel()
				);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(empService.list());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdEmpilhadeira(@PathVariable UUID id) {
		Optional<EmpilhadeiraModel> empOptinal = empService.findByEmpilhadeira(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}

		return ResponseEntity.status(HttpStatus.OK).body(empOptinal.get());

	}

	@PostMapping
	public ResponseEntity<EmpilhadeiraModel> saveEmpilhadeira(@RequestBody @Valid EmpilhadeiraRecordDTO empDTO) {
		var empModel = new EmpilhadeiraModel();
		BeanUtils.copyProperties(empDTO, empModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.salvar(empModel));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmpilhadeira(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid EmpilhadeiraRecordDTO empDTO) {

		Optional<EmpilhadeiraModel> empOptinal = empService.findByEmpilhadeira(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}

		var empModel = empOptinal.get();
		BeanUtils.copyProperties(empDTO, empModel);
		return ResponseEntity.status(HttpStatus.OK).body(empService.salvar(empModel));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmpilhadeira(@PathVariable(value = "id") UUID id) {

		Optional<EmpilhadeiraModel> empOptinal = empService.findByEmpilhadeira(id);
		if (empOptinal.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empilhadeira não localizada");
		}
		empService.delete(empOptinal.get());
		return ResponseEntity.status(HttpStatus.OK).body("Successfully");
	}

}

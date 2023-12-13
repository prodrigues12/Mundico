package com.example.mundico.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mundico.models.EmpilhadeiraModel;
import com.example.mundico.repositories.EmpilhadeiraRepository;

@Service
public class EmpilhadeiraService {
	
	@Autowired
	private EmpilhadeiraRepository empRepository;

	private Logger logger = Logger.getLogger(EmpilhadeiraService.class.getName());
	
	public List<EmpilhadeiraModel> list(){
		logger.info("-> List all empilhadeiras");
		return empRepository.findAll();
	}
	
	public Optional<EmpilhadeiraModel> findByEmpilhadeira(UUID id){
		logger.info("-> Get empilhadeira");
		return empRepository.findById(id);
	}
	
	public EmpilhadeiraModel salvar(EmpilhadeiraModel empModel) {
		logger.info("-> Save empilhadeira");
		return empRepository.save(empModel);
	}
	
	public void delete (EmpilhadeiraModel empModel) {
		logger.info("-> Delete empilhadeira");
		empRepository.delete(empModel);
		
	}
	
}

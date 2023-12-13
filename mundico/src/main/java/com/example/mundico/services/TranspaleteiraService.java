package com.example.mundico.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mundico.models.TranspaleteiraModel;
import com.example.mundico.repositories.TranspaleteiraRepository;

@Service
public class TranspaleteiraService {
	
	@Autowired
	private TranspaleteiraRepository transRepository;

	private Logger logger = Logger.getLogger(TranspaleteiraService.class.getName());
	
	public List<TranspaleteiraModel> listAllTranspareteira(){
		logger.info("-> List all empilhadeiras");
		return transRepository.findAll();
	}
	
	public Optional<TranspaleteiraModel> findByTranspaleteira(UUID id) {
		logger.info("-> Get transpaleteira");
		return transRepository.findById(id);
	}
	
	public TranspaleteiraModel createTranspaleteira(TranspaleteiraModel transpaleteira) {
		logger.info("-> Save transpaleteira");
		return transRepository.save(transpaleteira);

	}
	
	public TranspaleteiraModel updateTranspaleteira(TranspaleteiraModel model) {
		return transRepository.save(model);
	}
	
	public void deleteTranspaleteira(TranspaleteiraModel model) {
		transRepository.delete(model);
	}
}

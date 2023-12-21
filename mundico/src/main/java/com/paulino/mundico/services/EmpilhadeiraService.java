package com.paulino.mundico.services;

import com.paulino.mundico.DTO.EmpilhadeiraDTO;
import com.paulino.mundico.domain.Empilhadeira;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmpilhadeiraService {

    @Autowired
    private EmpilhadeiraRepository empRepository;

    public Empilhadeira createEmp(EmpilhadeiraDTO empDTO) {
        Empilhadeira emp = new Empilhadeira(empDTO);
        return empRepository.save(emp);
    }

    public List<Empilhadeira> getAllEmpilhadeira() {
        return empRepository.findAll();
    }

    public Empilhadeira findEmpId(Long id) throws Exception {
        return empRepository.findById(id).orElseThrow(() -> new Exception());
    }

    public Empilhadeira updateEmp(Long id, EmpilhadeiraDTO dto) {
        Optional<Empilhadeira> empOpt = empRepository.findById(id);

        if (empOpt.isPresent()) {
            Empilhadeira emp = empOpt.get();

            emp.setNumero(dto.numero());
            emp.setMarca(dto.marca());
            emp.setModelo(dto.modelo());
            emp.setTipo(dto.tipo());
            emp.setChassi(dto.chassi());

            return empRepository.save(emp);
        } else {
            throw new NoSuchElementException("Empilhadeira não encontrada com o ID: " + id);
        }
    }

    public void deleteEmpilhadeira(Long id) {
        empRepository.deleteById(id);
    }

    public boolean validarStatus(Integer numero) throws Exception {
        Optional<Empilhadeira> empilhadeira =  empRepository.findByNumero(numero);
        if (empilhadeira.get().isStatus()) {
            throw new Exception("Empilhada aguardando manutenção");
        } else {
            return true;
        }
    }
}

package com.paulino.mundico.services;

import com.paulino.mundico.DTO.EmpilhadeiraDTO;
import com.paulino.mundico.domain.Empilhadeira;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpilhadeiraService {

    @Autowired
    private EmpilhadeiraRepository empRepository;




    public Empilhadeira createEmp(EmpilhadeiraDTO empDTO){
        Empilhadeira emp = new Empilhadeira(empDTO);
        return empRepository.save(emp);
    }

    public List<Empilhadeira> getAllEmpilhadeira(){
        return empRepository.findAll();
    }

    public Empilhadeira findEmpId(Long id) throws Exception {
        return empRepository.findById(id).orElseThrow(()-> new Exception());
        }

    public Empilhadeira updateEmp(Long id, EmpilhadeiraDTO dto ){
       Optional<Empilhadeira> empOpt = empRepository.findById(id);
       Empilhadeira emp = empOpt.get();

       return empRepository.save(emp);

    }
    public void deleteEmpilhadeira(Long id){
        empRepository.deleteById(id);
    }
}

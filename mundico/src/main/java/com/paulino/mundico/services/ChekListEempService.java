package com.paulino.mundico.services;

import com.paulino.mundico.DTO.ChekListEmpDTO;
import com.paulino.mundico.domain.CheckListEmpilhadeira;
import com.paulino.mundico.repositories.CheckListEmpRepository;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ChekListEempService {

    @Autowired
    private CheckListEmpRepository repository;

    @Autowired
    private EmpilhadeiraService empService;

    private EmpilhadeiraRepository empilhadeiraRepository;


    public CheckListEmpilhadeira createCheckEmp(ChekListEmpDTO dto) {
        CheckListEmpilhadeira chek = new CheckListEmpilhadeira(dto);
        repository.save(chek);
    }

    public List<CheckListEmpilhadeira> checkListEmpilhadeiras() {
        return repository.findAll();
    }

    public boolean verificarRepsostaFalse(ChekListEmpDTO dto) {
        return !Stream.of(dto.pergunta1()).allMatch(Boolean.TRUE::equals);
    }


}

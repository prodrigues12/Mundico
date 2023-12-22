package com.paulino.mundico.services;

import com.paulino.mundico.DTO.CheckinEmpDTO;
import com.paulino.mundico.domain.CheckinEmpilhadeira;
import com.paulino.mundico.domain.Empilhadeira;
import com.paulino.mundico.repositories.CheckinEmpRepository;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ChekinEmpService {

    @Autowired
    private CheckinEmpRepository repository;

    @Autowired
    private EmpilhadeiraService empService;
    @Autowired
    private EmpilhadeiraRepository empRepository;

    public CheckinEmpilhadeira createCheckEmp(CheckinEmpDTO dto) {
        CheckinEmpilhadeira novoCheckList = new CheckinEmpilhadeira(dto);



        if (verificarRepsostaFalse(dto)) {
            //status da empilhaderia tem q ser falso
            Optional<Empilhadeira> empilhadeira = empRepository.findByNumero(dto.numero());

            Empilhadeira emp = new Empilhadeira();
            emp = empilhadeira.get();
            emp.setStatus(Boolean.FALSE);
        }

        return repository.save(novoCheckList);
    }



    public List<CheckinEmpilhadeira> lisCheckinEmp() {
        return repository.findAll();
    }

    public boolean verificarRepsostaFalse(CheckinEmpDTO dto) {
        return !Stream.of(dto.pergunta1()).allMatch(Boolean.TRUE::equals);
    }


}

package com.paulino.mundico;

import com.paulino.mundico.DTO.EmpilhadeiraDTO;
import com.paulino.mundico.domain.Empilhadeira;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
public class EmpRepositoryTest {

    @Autowired
    EmpilhadeiraRepository repository;

    @Autowired
    EntityManager entityManager;

    private Empilhadeira createEmp (EmpilhadeiraDTO dto){
        Empilhadeira emp = new Empilhadeira(dto);
        return repository.save(emp);
    }

    @Test
    @DisplayName("Empilhadareia exitente no banco")
    void findEmpCaseEmpExisting(){
        String chassi = "12345678";
        EmpilhadeiraDTO data = new EmpilhadeiraDTO(1,"paletrans","PRi20","eletrica",chassi);
        createEmp(data);

        System.out.println("#############"+ data.chassi().toString());
        Optional<Empilhadeira> result = repository.findByChassi(chassi);
        assertThat(result.isPresent()).isTrue();

    }

    @Test
    @DisplayName("Empilhadareia Não exitente no banco")
    void findEmpCaseNotExisteting() {

        String chassi = "12345678";
        Optional<Empilhadeira> result = repository.findByChassi(chassi);

        assertThat(result.isPresent()).isFalse();
    }


}

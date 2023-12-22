package com.paulino.mundico;

import com.paulino.mundico.repositories.CheckinEmpRepository;
import com.paulino.mundico.repositories.EmpilhadeiraRepository;
import com.paulino.mundico.services.ChekinEmpService;
import com.paulino.mundico.services.EmpilhadeiraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


public class CheckinEmpTest {

    @Mock
    private EmpilhadeiraService empilhadeiraService;

    @Mock
    private EmpilhadeiraRepository empilhadeiraRepository;

    @Mock
    CheckinEmpRepository checkinEmpRepository;

    @Autowired
    @InjectMocks
    private ChekinEmpService chekinEmpService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("novo cadastro sucesso")
    void chekinEmpSuccefully(){

    }
}

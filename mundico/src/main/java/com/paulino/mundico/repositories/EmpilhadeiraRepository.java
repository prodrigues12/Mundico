package com.paulino.mundico.repositories;

import com.paulino.mundico.domain.Empilhadeira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpilhadeiraRepository extends JpaRepository <Empilhadeira, Long> {

    Optional<Empilhadeira> findByNumero(Integer numero);
}

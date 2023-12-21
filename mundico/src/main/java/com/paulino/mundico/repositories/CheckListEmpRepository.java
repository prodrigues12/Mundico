package com.paulino.mundico.repositories;

import com.paulino.mundico.domain.CheckListEmpilhadeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckListEmpRepository extends JpaRepository<CheckListEmpilhadeira, Long> {


}

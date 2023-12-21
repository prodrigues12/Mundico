package com.paulino.mundico.repositories;

import com.paulino.mundico.domain.CheckinEmpilhadeira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckinEmpRepository extends JpaRepository<CheckinEmpilhadeira, Long> {


}

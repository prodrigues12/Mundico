package com.example.mundico.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mundico.models.TranspaleteiraModel;

@Repository
public interface TranspaleteiraRepository extends JpaRepository<TranspaleteiraModel, UUID> {

}

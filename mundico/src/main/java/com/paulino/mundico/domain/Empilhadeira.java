package com.paulino.mundico.domain;

import com.paulino.mundico.DTO.EmpilhadeiraDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "empilhadeiras")
public class Empilhadeira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;
    private int numero;
    private String marca;
    private String modelo;
    private String tipo;
    @Column(unique = true)
    private String chassi;

    public Empilhadeira (EmpilhadeiraDTO dto) {
        this.numero = dto.numero();
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.tipo = dto.tipo();
        this.chassi = dto.chassi();
    }



}

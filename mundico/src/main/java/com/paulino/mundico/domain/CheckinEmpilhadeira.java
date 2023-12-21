package com.paulino.mundico.domain;

import com.paulino.mundico.DTO.CheckinEmpDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckinEmpilhadeira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idMagalu;
    private int numero;

    @Enumerated(EnumType.STRING)
    private SetorType setor;
    @Enumerated(EnumType.STRING)
    private TurnoType turno;

    private BigDecimal horimetro;

    private boolean pergunta1;

    private boolean status;

    public CheckinEmpilhadeira(CheckinEmpDTO dto){
        this.idMagalu= dto.idmagalu();
        this.numero = dto.numero();
        this.setor= dto.setorType();
        this.turno = dto.turnoType();
        this.horimetro=dto.horimetro();
        this.pergunta1=dto.pergunta1();
    }


}

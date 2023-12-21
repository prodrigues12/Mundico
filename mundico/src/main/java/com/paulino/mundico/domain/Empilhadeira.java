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

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Empilhadeira (EmpilhadeiraDTO dto) {
        this.numero = dto.numero();
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.tipo = dto.tipo();
        this.chassi = dto.chassi();
    }



}

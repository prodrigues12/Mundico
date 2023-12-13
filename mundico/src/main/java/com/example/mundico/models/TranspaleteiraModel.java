package com.example.mundico.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TRANSPALETEIRA")
public class TranspaleteiraModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idTranspareteira;
	private String nome;
	private String marca;
	private String modelo;
	private String tipo;
	private boolean status;
	
	public TranspaleteiraModel() {
		super();
	}

	public UUID getIdTranspareteira() {
		return idTranspareteira;
	}

	public void setIdTranspareteira(UUID idTranspareteira) {
		this.idTranspareteira = idTranspareteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTranspareteira, marca, modelo, nome, status, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TranspaleteiraModel other = (TranspaleteiraModel) obj;
		return Objects.equals(idTranspareteira, other.idTranspareteira) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(nome, other.nome) && status == other.status
				&& Objects.equals(tipo, other.tipo);
	}
	
	
	
	
	
	
	

}

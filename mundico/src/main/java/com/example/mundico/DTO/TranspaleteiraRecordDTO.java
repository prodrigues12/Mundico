package com.example.mundico.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TranspaleteiraRecordDTO(

		@NotBlank String nome, @NotBlank String marca, @NotBlank String modelo, @NotBlank String tipo,
		@NotNull boolean status) {

}

package com.paulino.mundico.DTO;

import com.paulino.mundico.domain.SetorType;
import com.paulino.mundico.domain.TurnoType;

import java.math.BigDecimal;

public record CheckinEmpDTO(String idmagalu, int numero, SetorType setorType, TurnoType turnoType, BigDecimal horimetro,
                            boolean pergunta1) {
}

package com.example.AlejandroSPEOI.juego.dto;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JuegoDTO {

    private Long id;
    private String nombre;
    private Boolean completado;
    private Long generoId;
}

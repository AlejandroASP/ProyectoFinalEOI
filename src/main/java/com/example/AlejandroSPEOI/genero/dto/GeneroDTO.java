package com.example.AlejandroSPEOI.genero.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneroDTO {
    private Long id;
    @NotBlank(message = "El nombre del genero no se puede dejar vacío")
    private String nombre;
}

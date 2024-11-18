package com.example.AlejandroSPEOI.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
@Data @NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "El usuario no puede estar vacío")
    private String nombre;
    @NotBlank(message = "La contraseña es obligatoria")
    private String correo;
}

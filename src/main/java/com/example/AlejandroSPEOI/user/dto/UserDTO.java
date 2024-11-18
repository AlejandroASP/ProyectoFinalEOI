package com.example.AlejandroSPEOI.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data @NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "El usuario no puede estar vacío")
    private String user;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

     public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

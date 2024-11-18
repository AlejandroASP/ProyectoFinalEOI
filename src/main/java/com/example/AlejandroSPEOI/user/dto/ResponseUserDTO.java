package com.example.AlejandroSPEOI.user.dto;

import com.example.AlejandroSPEOI.user.proyecciones.Users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseUserDTO {
    private Users usuario;
}

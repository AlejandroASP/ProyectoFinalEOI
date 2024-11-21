package com.example.AlejandroSPEOI.juego.dto;

import com.example.AlejandroSPEOI.juego.proyecciones.Juegos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseJuegoDTO {
    private Juegos game;

}

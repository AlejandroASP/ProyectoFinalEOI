package com.example.AlejandroSPEOI.juego.dto;

import java.util.List;

import com.example.AlejandroSPEOI.juego.Juego;
import com.example.AlejandroSPEOI.juego.proyecciones.Juegos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaJuegosDTO {
    private List<Juego> games;
}

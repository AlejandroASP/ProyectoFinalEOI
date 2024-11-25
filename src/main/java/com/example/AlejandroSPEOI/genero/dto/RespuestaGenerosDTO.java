package com.example.AlejandroSPEOI.genero.dto;

import java.util.List;

import com.example.AlejandroSPEOI.genero.Genero;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaGenerosDTO {
    private List<Genero> generos;
}

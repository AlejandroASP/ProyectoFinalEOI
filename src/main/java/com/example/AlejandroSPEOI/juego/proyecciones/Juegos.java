package com.example.AlejandroSPEOI.juego.proyecciones;

import com.example.AlejandroSPEOI.genero.Genero;

public interface Juegos {
    Long getId();

    String getNombre();

    Boolean getCompletado();

    Genero getGenero();
}

package com.example.AlejandroSPEOI.genero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AlejandroSPEOI.genero.proyecciones.Generos;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    List<Genero> findBy();

    Generos findGameById(int id);
}

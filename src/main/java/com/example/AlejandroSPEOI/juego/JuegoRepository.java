package com.example.AlejandroSPEOI.juego;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AlejandroSPEOI.juego.proyecciones.Juegos;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {
    List<Juego> findBy();

    Juegos findGameById(int id);
}

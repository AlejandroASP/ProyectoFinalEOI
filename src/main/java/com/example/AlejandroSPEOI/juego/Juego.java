package com.example.AlejandroSPEOI.juego;

import com.example.AlejandroSPEOI.genero.Genero;
import com.example.AlejandroSPEOI.juego.dto.JuegoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean completado;
    @ManyToOne
    @JoinColumn(name = "fk_genero")
    private Genero genero;
}
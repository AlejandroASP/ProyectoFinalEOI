package com.example.AlejandroSPEOI.game;

import java.sql.Date;

import com.example.AlejandroSPEOI.user.User;

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
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Date fechaCompletado;
    private long horasDedicadas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;
}

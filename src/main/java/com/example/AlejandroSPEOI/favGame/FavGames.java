package com.example.AlejandroSPEOI.favGame;

import com.example.AlejandroSPEOI.game.Games;
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
public class FavGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String motivo; // Campo opcional

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "juego_id")
    private Games juego;
}

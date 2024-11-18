package com.example.AlejandroSPEOI.user;

import java.util.List;

import com.example.AlejandroSPEOI.game.Games;
import com.example.AlejandroSPEOI.favGame.FavGames;
import com.example.AlejandroSPEOI.user.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Games> juegos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<FavGames> juegosFavoritos;

    static User fromDTO(UserDTO usuarioDTO) {
        return new User(0, usuarioDTO.getUser(), usuarioDTO.getPassword(), null, null);
    }
}

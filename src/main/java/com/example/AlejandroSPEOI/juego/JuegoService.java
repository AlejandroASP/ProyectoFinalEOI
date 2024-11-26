package com.example.AlejandroSPEOI.juego;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AlejandroSPEOI.genero.Genero;
import com.example.AlejandroSPEOI.genero.GeneroRepository;
import com.example.AlejandroSPEOI.juego.dto.JuegoDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public List<Juego> findAll() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> findById(Long id) {
        return juegoRepository.findById(id);
    }

    public Juego save(JuegoDTO juegoDTO) {
        Juego juego = new Juego();
        juego.setNombre(juegoDTO.getNombre());
        juego.setCompletado(juegoDTO.getCompletado());
        if (juegoDTO.getGeneroId() != null) {
            Genero genero = generoRepository.findById(juegoDTO.getGeneroId())
                    .orElseThrow(() -> new RuntimeException("Genero no encontrado"));
            juego.setGenero(genero);
        }
        return juegoRepository.save(juego);
    }

    public Juego updateJuego(Long id, JuegoDTO juegoDTO) {
        // Buscar el juego existente
        Juego juegoExistente = juegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));

        // Actualizar los campos del juego
        juegoExistente.setNombre(juegoDTO.getNombre());
        juegoExistente.setCompletado(juegoDTO.getCompletado());

        // Actualizar el género si se proporciona
        if (juegoDTO.getGeneroId() != null) {
            Genero genero = generoRepository.findById(juegoDTO.getGeneroId())
                    .orElseThrow(() -> new RuntimeException("Genero no encontrado"));
            juegoExistente.setGenero(genero);
        }

        // Guardar los cambios
        return juegoRepository.save(juegoExistente);
    }

    public void deleteById(Long id) {
        juegoRepository.deleteById(id);
    }

}

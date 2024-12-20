package com.example.AlejandroSPEOI.juego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AlejandroSPEOI.juego.dto.JuegoDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/juegos")
@RequiredArgsConstructor
public class JuegoController {
    @Autowired
    private JuegoService juegoService;

    @GetMapping
    public List<Juego> getAllJuegos() {
        return juegoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> getJuegoById(@PathVariable Long id) {
        return juegoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Juego createJuego(@RequestBody JuegoDTO juegoDTO) {
        return juegoService.save(juegoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juego> updateJuego(@PathVariable Long id, @RequestBody Juego juego) {
        // Convertir el objeto Juego a JuegoDTO
        JuegoDTO juegoDTO = new JuegoDTO();
        juegoDTO.setNombre(juego.getNombre());
        juegoDTO.setCompletado(juego.getCompletado());
        if (juego.getGenero() != null) {
            juegoDTO.setGeneroId(juego.getGenero().getId());
        }

        // Llamar al servicio con el DTO
        Juego juegoActu = juegoService.updateJuego(id, juegoDTO);
        return ResponseEntity.ok(juegoActu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJuego(@PathVariable Long id) {
        juegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
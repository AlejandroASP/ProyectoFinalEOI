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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJuego(@PathVariable Long id) {
        juegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
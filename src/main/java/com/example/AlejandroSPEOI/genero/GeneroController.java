package com.example.AlejandroSPEOI.genero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AlejandroSPEOI.genero.dto.GeneroDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class GeneroController {
    @Autowired
    private final GeneroService generoService;

    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Long id) {
        return generoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Genero createGenero(@RequestBody Genero genero) {
        return generoService.save(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> actualizarGenero(@PathVariable Long id, @RequestBody Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setNombre(null);

        Genero generoActu = generoService.updateGenero(id, generoDTO);
        return ResponseEntity.ok(generoActu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        generoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
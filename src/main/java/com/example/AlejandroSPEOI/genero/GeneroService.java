package com.example.AlejandroSPEOI.genero;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}

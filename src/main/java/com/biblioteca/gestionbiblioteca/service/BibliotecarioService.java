package com.biblioteca.gestionbiblioteca.service;

import com.biblioteca.gestionbiblioteca.model.Bibliotecario;
import com.biblioteca.gestionbiblioteca.repository.BibliotecarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {
    private final BibliotecarioRepository bibliotecarioRepository;

    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public List<Bibliotecario> findAll() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> findById(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    public Bibliotecario save(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public void deleteById(Long id) {
        bibliotecarioRepository.deleteById(id);
    }
}

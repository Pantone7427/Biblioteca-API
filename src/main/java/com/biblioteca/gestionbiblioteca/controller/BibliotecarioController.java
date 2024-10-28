package com.biblioteca.gestionbiblioteca.controller;

import com.biblioteca.gestionbiblioteca.model.Bibliotecario;
import com.biblioteca.gestionbiblioteca.service.BibliotecarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecarios")
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    public BibliotecarioController(BibliotecarioService bibliotecarioService) {
        this.bibliotecarioService = bibliotecarioService;
    }

    @GetMapping
    public List<Bibliotecario> findAll() {
        return bibliotecarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> findById(@PathVariable Long id) {
        return bibliotecarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bibliotecario> save(@RequestBody Bibliotecario bibliotecario) {
        Bibliotecario savedBibliotecario = bibliotecarioService.save(bibliotecario);
        return ResponseEntity.ok(savedBibliotecario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> update(@PathVariable Long id, @RequestBody Bibliotecario bibliotecario) {
        if (!bibliotecarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bibliotecario.setId(id);
        Bibliotecario updatedBibliotecario = bibliotecarioService.save(bibliotecario);
        return ResponseEntity.ok(updatedBibliotecario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!bibliotecarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bibliotecarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
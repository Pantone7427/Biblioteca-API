package com.biblioteca.gestionbiblioteca.controller;

import com.biblioteca.gestionbiblioteca.model.Prestamo;
import com.biblioteca.gestionbiblioteca.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> findAll() {
        return prestamoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> findById(@PathVariable Long id) {
        return prestamoService.findById(id)
                .map(prestamo -> ResponseEntity.ok(prestamo))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prestamo save(@RequestBody Prestamo prestamo) {
        return prestamoService.save(prestamo);
    }

    @PutMapping("/{id}")
    public Prestamo update(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        prestamo.setId(id);
        return prestamoService.save(prestamo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        prestamoService.deleteById(id);
    }
}


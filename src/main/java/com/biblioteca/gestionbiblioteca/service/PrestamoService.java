package com.biblioteca.gestionbiblioteca.service;

import com.biblioteca.gestionbiblioteca.model.Prestamo;
import com.biblioteca.gestionbiblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Prestamo save(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void deleteById(Long id) {
        prestamoRepository.deleteById(id);
    }

    public Optional<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id);
    }
}

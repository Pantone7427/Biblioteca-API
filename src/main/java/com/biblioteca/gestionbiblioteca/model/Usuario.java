package com.biblioteca.gestionbiblioteca.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuario extends Persona {
    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;

    // Getters y setters
    public List<Prestamo> getPrestamos() { return prestamos; }
    public void setPrestamos(List<Prestamo> prestamos) { this.prestamos = prestamos; }
}

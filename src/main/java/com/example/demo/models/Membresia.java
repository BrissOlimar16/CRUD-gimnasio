package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresias")
    private Long idMembresia;

    @Column(name = "nombreM", nullable = false, unique = true)
    private String nombreMembresia;

    @Column(nullable = false)
    private BigDecimal precio;

    public Membresia() {
    }

    public Membresia(Long idMembresias, String nombreMembresia, BigDecimal precio) {
        this.idMembresia = idMembresias;
        this.nombreMembresia = nombreMembresia;
        this.precio = precio;
    }

    public Long getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Long idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getNombreMembresia() {
        return nombreMembresia;
    }

    public void setNombreMembresia(String nombreMembresia) {
        this.nombreMembresia = nombreMembresia;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}

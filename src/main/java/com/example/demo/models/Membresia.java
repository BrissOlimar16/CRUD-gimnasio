package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresias")
    private int idMembresia;

    @NotBlank(message = "Ingrese el tipo de membresia")
    @Column(name = "nombreM", nullable = false, unique = true)
    private String nombreMembresia;

    @NotBlank(message = "Ingrese el precio de membresia")
    @Column(nullable = false)
    private BigDecimal precio;

    public Membresia() {
    }

    public Membresia(int idMembresias, String nombreMembresia, BigDecimal precio) {
        this.idMembresia = idMembresias;
        this.nombreMembresia = nombreMembresia;
        this.precio = precio;
    }

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
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

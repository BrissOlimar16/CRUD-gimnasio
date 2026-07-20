package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresias")
    private Integer idMembresia;

    @NotBlank(message = "Ingrese el tipo de membresia")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "El nombre solo debe contener letras y espacios")
    @Column(name = "nombreM", nullable = false, unique = true)
    private String nombreMembresia;

    @NotNull(message = "Ingrese el precio de membresia")
    @DecimalMin(value = "0.0", message = "EL precio debe ser mayor a 0")
    @Column(nullable = false)
    private BigDecimal precio;

    public Membresia() {
    }

    public Membresia(Integer idMembresias, String nombreMembresia, BigDecimal precio) {
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

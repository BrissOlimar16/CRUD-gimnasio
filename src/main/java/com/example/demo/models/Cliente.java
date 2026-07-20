package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @NotBlank(message = "Ingresa el nombre del cliente!")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$",
            message = "El nombre solo debe contener letras y espacios")
    @Column(name = "nombreC", length = 100)
    private String nombre;

    @NotBlank(message = "Ingresa el correo electrónico del cliente!")
    @Email(message = "La dirección de correo no es correcta!")
    @Column(unique = true, length = 100)
    private String correo;

    @NotBlank(message = "Ingresa el número de teléfono del cliente")
    @Pattern(regexp = "^[0-9]{10}$", message = "El número telefonico debe ser de 10 dígitos")
    @Column(length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_membresia", referencedColumnName = "id_membresias")
    private Membresia membresia;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String correo, String telefono, Membresia membresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.membresia = membresia;
    }


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}

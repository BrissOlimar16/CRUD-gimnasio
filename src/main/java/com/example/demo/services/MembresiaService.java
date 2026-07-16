package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.Membresia;
import java.util.List;

public interface MembresiaService {
    List<Membresia> listarTodas();
    Membresia guardar(Membresia membresia);
    Membresia obtenerId(Integer id);
    Membresia actualizar(Integer id, Membresia membresiaActualizada);
    void eliminar(Integer id);
}

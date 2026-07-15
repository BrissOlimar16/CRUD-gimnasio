package com.example.demo.services;

import com.example.demo.models.Membresia;
import java.util.List;

public interface MembresiaService {
    List<Membresia> listarTodas();
    Membresia guardar(Membresia membresia);
    Membresia obtenerId(Long id);
    void eliminar(Long id);
}

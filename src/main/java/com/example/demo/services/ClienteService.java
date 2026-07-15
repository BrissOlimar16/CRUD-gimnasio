package com.example.demo.services;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodas();
    Cliente guardar(Cliente cliente);
    Cliente obtenerId(Long id);
    void eliminar(Long id);
}

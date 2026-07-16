package com.example.demo.services;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodas();
    Cliente guardar(Cliente cliente);
    Cliente obtenerId(Integer id);
    Cliente actualizar(Integer id, Cliente clienteActualizado);
    void eliminar(Integer id);
}

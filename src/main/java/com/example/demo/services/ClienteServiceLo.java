package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceLo implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodas(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerId (Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente actualizar(Integer id, Cliente clienteActualizado){
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if(clienteExistente == null){
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());
        clienteExistente.setTelefono(clienteActualizado.getTelefono());
        clienteExistente.setMembresia(clienteActualizado.getMembresia());
        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void eliminar(Integer id){
        clienteRepository.deleteById(id);
    }
}

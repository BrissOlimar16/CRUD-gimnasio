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
    public Cliente obtenerId (Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        clienteRepository.deleteById(id);
    }
}

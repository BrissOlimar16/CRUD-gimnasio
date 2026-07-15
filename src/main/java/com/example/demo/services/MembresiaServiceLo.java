package com.example.demo.services;

import com.example.demo.models.Membresia;
import com.example.demo.repository.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MembresiaServiceLo implements MembresiaService{
    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public List<Membresia> listarTodas(){
        return membresiaRepository.findAll();
    }

    @Override
    public Membresia guardar(Membresia membresia){
        return membresiaRepository.save(membresia);
    }

    @Override
    public Membresia obtenerId(Long id){
        return membresiaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id){
        membresiaRepository.deleteById(id);
    }
}

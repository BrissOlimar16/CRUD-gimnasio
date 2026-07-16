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
    public Membresia obtenerId(Integer id){
        return membresiaRepository.findById(id).orElse(null);
    }

    @Override
    public Membresia actualizar(Integer id, Membresia membresiaActualizada){
        Membresia membresiaExistetente = membresiaRepository.findById(id).orElse(null);
        if(membresiaExistetente == null){
            throw new RuntimeException("Membresia no encontrada");
        }
        membresiaExistetente.setNombreMembresia(membresiaActualizada.getNombreMembresia());
        membresiaExistetente.setPrecio(membresiaActualizada.getPrecio());
        return membresiaRepository.save(membresiaExistetente);
    }

    @Override
    public void eliminar(Integer id){
        membresiaRepository.deleteById(id);
    }
}

package com.example.demo.controllers;

import com.example.demo.models.Membresia;
import com.example.demo.services.MembresiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/membresias")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorMembresia {
    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public List<Membresia> listarTodas(){
        return membresiaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membresia> obtenerId(@PathVariable Integer id){
        Membresia membresia = membresiaService.obtenerId(id);
        if(membresia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(membresia, HttpStatus.OK);
    }

    @Valid
    @PostMapping
    public ResponseEntity<Membresia> guardar(@RequestBody Membresia membresia){
        Membresia nuevaMembresia = membresiaService.guardar(membresia);
        return new ResponseEntity<>(nuevaMembresia, HttpStatus.CREATED);
    }

    @Valid
    @PutMapping("/{id}")
    public ResponseEntity<Membresia> actualizar(@PathVariable Integer id, @RequestBody Membresia membresia){
        Membresia membresiaActualizada = membresiaService.actualizar(id, membresia);
        return ResponseEntity.ok(membresiaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Membresia membresia = membresiaService.obtenerId(id);
        if(membresia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        membresiaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

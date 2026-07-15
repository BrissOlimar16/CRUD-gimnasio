package com.example.demo.controllers;

import com.example.demo.models.Membresia;
import com.example.demo.services.MembresiaService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/membresias")
@CrossOrigin(origins = "*")
public class ControladorMembresia {
    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public List<Membresia> listarTodas(){
        return membresiaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membresia> obtenerId(@PathVariable Long id){
        Membresia membresia = membresiaService.obtenerId(id);
        if(membresia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(membresia, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Membresia> guardar(@RequestBody Membresia membresia){
        Membresia nuevaMembresia = membresiaService.guardar(membresia);
        return new ResponseEntity<>(nuevaMembresia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Membresia membresia = membresiaService.obtenerId(id);
        if(membresia == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        membresiaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

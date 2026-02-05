package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Especie;
import com.example.demo.service.EspecieService;


@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    @PostMapping
    public ResponseEntity<Especie> crearEspecie(@RequestBody Especie especie) {
        Especie nuevaEspecie = especieService.crearEspecie(especie);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEspecie);
    }
    // Read all
    @GetMapping
    public List<Especie> obtenerTodasLasEspecies() {
        return especieService.obtenerTodasLasEspecies();
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Especie> obtenerEspeciePorId(@PathVariable Integer id) {
        Optional<Especie> especie = especieService.obtenerEspeciePorId(id);
        return especie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Especie> actualizarEspecie(@PathVariable Integer id, @RequestBody Especie detallesEspecie) {
        Optional<Especie> especieExistente = especieService.obtenerEspeciePorId(id);
        if (especieExistente.isPresent()) {
            Especie especie = especieExistente.get();
            especie.setNombre(detallesEspecie.getNombre());
            especie.setDescripcion(detallesEspecie.getDescripcion());
            especie.setTipo(detallesEspecie.getTipo());
            Especie especieActualizada = especieService.actualizarEspecie(especie);
            return ResponseEntity.ok(especieActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecie(@PathVariable Integer id) {
        Optional<Especie> especie = especieService.obtenerEspeciePorId(id);
        if (especie.isPresent()) {
            especieService.eliminarEspecie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
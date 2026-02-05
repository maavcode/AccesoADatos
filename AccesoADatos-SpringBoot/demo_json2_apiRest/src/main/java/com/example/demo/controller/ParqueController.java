package com.example.demo.controller;

import com.example.demo.model.Parque;
import com.example.demo.service.ParqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/parques")
public class ParqueController {

    @Autowired
    private ParqueService parqueService;

    // Crear un nuevo parque
    @PostMapping
    public ResponseEntity<Parque> crearParque(@RequestBody Parque parque) {
        Parque nuevoParque = parqueService.crearParque(parque);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoParque);
    }

    // Obtener todos los parques
    @GetMapping
    public ResponseEntity<List<Parque>> obtenerTodosLosParques() {
        List<Parque> parques = parqueService.obtenerTodosLosParques();
        return ResponseEntity.ok(parques);
    }

    // Obtener un parque por ID
    @GetMapping("/{id}")
    public ResponseEntity<Parque> obtenerParquePorId(@PathVariable Integer id) {
        Optional<Parque> parque = parqueService.obtenerParquePorId(id);
        return parque.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Actualizar un parque
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Parque> actualizarParque(@PathVariable Integer id, @RequestBody Parque parque) {
        try {
            Parque parqueActualizado = parqueService.actualizarParque(id, parque);
            return ResponseEntity.ok(parqueActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un parque
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParque(@PathVariable Integer id) {
        try {
            parqueService.eliminarParque(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/comunidad/{comunidadNombre}")
    public List<Parque> obtenerParquesPorComunidad(@PathVariable String comunidadNombre) {
        return parqueService.obtenerParquesPorComunidad(comunidadNombre);
    }
}

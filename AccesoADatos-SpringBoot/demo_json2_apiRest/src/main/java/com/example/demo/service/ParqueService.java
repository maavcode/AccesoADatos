package com.example.demo.service;


import com.example.demo.model.Parque;
import com.example.demo.repository.ParqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueService {

    @Autowired
    private ParqueRepository parqueRepository;

    // Crear un nuevo parque
    public Parque crearParque(Parque parque) {
        return parqueRepository.save(parque);
    }

    // Obtener todos los parques
    public List<Parque> obtenerTodosLosParques() {
        return parqueRepository.findAll();
    }

    // Obtener un parque por su ID
    public Optional<Parque> obtenerParquePorId(Integer id) {
        return parqueRepository.findById(id);
    }

    // Actualizar un parque existente
    public Parque actualizarParque(Integer id, Parque parque) {
        if (parqueRepository.existsById(id)) {
            parque.setID(id);
            return parqueRepository.save(parque);
        }
        throw new RuntimeException("Parque no encontrado");
    }

    // Eliminar un parque por su ID
    public void eliminarParque(Integer id) {
        if (parqueRepository.existsById(id)) {
            parqueRepository.deleteById(id);
        } else {
            throw new RuntimeException("Parque no encontrado");
        }
    }
 // Método que llama al repositorio para obtener los parques de una comunidad autónoma
    public List<Parque> obtenerParquesPorComunidad(String nombre) {
        return parqueRepository.findParquesByComunidadAutonoma(nombre);
    }
}


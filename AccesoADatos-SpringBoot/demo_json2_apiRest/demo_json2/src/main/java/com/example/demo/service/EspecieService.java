package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Especie;
import com.example.demo.model.Parque;
import com.example.demo.repository.EspecieRepository;
import com.example.demo.repository.ParqueRepository;


@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private ParqueRepository parqueRepository;

        public Especie crearEspecie(Especie especie) {
            // Inicializar la lista de parques si es necesario
            if (especie.getParques() == null) {
                especie.setParques(new ArrayList<>());
            }

            // Asociar parques a la especie
            ArrayList<Parque> parques = new ArrayList<>();
            for (Parque parque : especie.getParques()) {
                Parque p = parqueRepository.findById(parque.getID()).orElseThrow(() -> new RuntimeException("Parque no encontrado"));
                parques.add(p);
            }
            especie.setParques(parques);

            // Guardar la especie en la base de datos
            return especieRepository.save(especie);
        }

        public List<Especie> obtenerTodasLasEspecies() {
            return especieRepository.findAll();
        }

        public Optional<Especie> obtenerEspeciePorId(Integer id) {
            return especieRepository.findById(id);
        }

        public Especie actualizarEspecie(Especie especie) {
            return especieRepository.save(especie);
        }

        public void eliminarEspecie(Integer id) {
            especieRepository.deleteById(id);
        }
    }



package com.example.demo.repository;


import com.example.demo.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
    // Puedes agregar métodos personalizados si los necesitas.
    // Por ejemplo, buscar una especie por su nombre:
    // Optional<Especie> findByNombre(String nombre);
}

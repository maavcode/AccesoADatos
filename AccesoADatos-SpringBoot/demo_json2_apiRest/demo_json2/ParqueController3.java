package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Parque;
import com.example.demo.repository.ParqueRepository;

import java.util.List;

@RestController
@RequestMapping("/api/parques")
public class ParqueController3 {

    @Autowired
    private ParqueRepository parqueRepository;

    @GetMapping
    public List<Parque> getAllParques() {
        return parqueRepository.findAll();
    }

    @GetMapping("/{id}")
    public Parque getParqueById(@PathVariable int id) {
        return parqueRepository.findById(id).orElse(null);
    }
}

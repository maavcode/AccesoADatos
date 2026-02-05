package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Parque;

public interface ParqueRepository extends JpaRepository<Parque, Integer> {
}

package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recomendacion;

@Repository
@Transactional
public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {

}

package com.example.repositories;

import com.example.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {

    List<Tienda> findAll ();
    Optional<Tienda> findById(Long id);
    Tienda save (Tienda tienda);

    void deleteById (Long id);
}
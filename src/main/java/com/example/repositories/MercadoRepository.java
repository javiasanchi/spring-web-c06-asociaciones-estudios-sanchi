package com.example.repositories;

import com.example.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {

    List<Mercado> findAllByNumPuestos(Integer numPuestos);
    List<Mercado> findAllByCiudad(String ciudad);


}
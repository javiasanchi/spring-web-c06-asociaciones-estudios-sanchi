package com.example.services;

import com.example.entities.Mercado;

import java.util.List;
import java.util.Optional;

public interface MercadoService {
    List<Mercado> findAll();
    Optional<Mercado> findById(Long id);
    Mercado save (Mercado mercado);
    void  deleteById (Long id);
    List<Mercado> findAllByNumPuestos(Integer numPuestos);
    List<Mercado> findAllByCiudad(String ciudad);


}

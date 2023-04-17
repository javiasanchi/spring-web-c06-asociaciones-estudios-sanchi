package com.example.services;

import com.example.entities.Tienda;
import com.example.repositories.TiendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class TiendaServiceImpl implements TiendaService {
    private final TiendaRepository tiendaRepo;
    @Override
    public List<Tienda> findAll() {
        return tiendaRepo.findAll();
    }

    @Override
    public Optional<Tienda> findById(Long id) {
        return tiendaRepo.findById(id);
    }

    @Override
    public Tienda save(Tienda tienda) {
        return tiendaRepo.save(tienda);
    }

    @Override
    public void deleteById(Long id) {
        tiendaRepo.deleteById(id);
    }

}

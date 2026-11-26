package com.example.aves.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aves.entity.Ave;
import com.example.aves.repository.AveRepository;
@Service
public class AveService {
 private final AveRepository repository ;

    public AveService(AveRepository repository) {
        this.repository = repository;
    }

    public List<Ave> listarTodas() {
        return repository.findAll();
    }

    public Ave obtenerPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ave no encontrada"));
    }

    public Ave guardar(Ave ave) {
        return repository.save(ave);
    }

    public Ave actualizar(Long id, Ave detalles) {
        Ave ave = obtenerPorId(id);
        ave.setEspecie(detalles.getEspecie());
        ave.setColor(detalles.getColor());
        return repository.save(ave);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

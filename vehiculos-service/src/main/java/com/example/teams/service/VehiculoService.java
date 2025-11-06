package com.example.teams.service;

import com.example.teams.model.Vehiculo;
import com.example.teams.repository.VehiculoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VehiculoService {
    private final VehiculoRepository repo;

    public VehiculoService(VehiculoRepository repo) {
        this.repo = repo;
    }

    public Flux<Vehiculo> findAll() { return repo.findAll(); }
    public Mono<Vehiculo> findById(Integer id) { return repo.findById(id); }
    public Mono<Vehiculo> create(Vehiculo t) { return repo.save(t); }
    public Mono<Vehiculo> update(Integer id, Vehiculo t) {
        return repo.findById(id)
            .flatMap(old -> repo.save(new Vehiculo(id, t.placa(), t.marca(), t.modelo(), t.clienteId())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

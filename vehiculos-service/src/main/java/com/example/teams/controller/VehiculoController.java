package com.example.teams.controller;

import com.example.teams.controller.dto.VehiculoRequests;
import com.example.teams.model.Vehiculo;
import com.example.teams.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teams")
public class VehiculoController {
    private final VehiculoService service;

    public VehiculoController(VehiculoService service) { this.service = service; }

    @GetMapping
    public Flux<Vehiculo> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mono<Vehiculo> byId(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public Mono<Vehiculo> create(@RequestBody @Valid VehiculoRequests.Create req) {
        return service.create(new Vehiculo(null, req.placa(), req.marca(), req.modelo(), req.clienteId()));
    }

    @PutMapping("/{id}")
    public Mono<Vehiculo> update(@PathVariable Integer id, @RequestBody @Valid VehiculoRequests.Update req) {
        return service.update(id, new Vehiculo(null, req.placa(), req.marca(), req.modelo(), req.clienteId()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}

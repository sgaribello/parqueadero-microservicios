package com.example.players.controller;

import com.example.players.controller.dto.ClienteRequests;
import com.example.players.model.Cliente;
import com.example.players.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public Flux<Cliente> all() { return service.all(); }

    @GetMapping("/{id}")
    public Mono<Cliente> byId(@PathVariable Integer id) { return service.byId(id); }


    @PostMapping
    public Mono<Cliente> create(@RequestBody @Valid ClienteRequests.Create req) {
        return service.create(new Cliente(null, req.fullName(), req.documento(), req.telefono()));
    }

    @PutMapping("/{id}")
    public Mono<Cliente> update(@PathVariable Integer id, @RequestBody @Valid ClienteRequests.Update req) {
        return service.update(id, new Cliente(null, req.fullName(), req.documento(), req.telefono()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}

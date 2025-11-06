package com.example.players.service;

import com.example.players.model.Cliente;
import com.example.players.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) { this.repo = repo; }

    public Flux<Cliente> all() { return repo.findAll(); }
    public Mono<Cliente> byId(Integer id) { return repo.findById(id); }
    public Flux<Cliente> byTeam(Integer teamId) { return repo.findByTeamId(teamId); }
    public Mono<Cliente> create(Cliente p) { return repo.save(p); }
    public Mono<Cliente> update(Integer id, Cliente p) {
        return repo.findById(id).flatMap(old -> repo.save(new Cliente(id, p.fullName(), p.documento(), p.telefono())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

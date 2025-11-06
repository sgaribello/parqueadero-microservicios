package com.example.players.repository;

import com.example.players.model.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Integer> {
    Flux<Cliente> findByTeamId(Integer teamId);
}

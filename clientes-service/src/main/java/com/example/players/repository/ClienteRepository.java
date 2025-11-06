package com.example.players.repository;

import com.example.players.model.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Integer> {
}

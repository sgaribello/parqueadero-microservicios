package com.example.teams.repository;

import com.example.teams.model.Vehiculo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VehiculoRepository extends ReactiveCrudRepository<Vehiculo, Integer> {}

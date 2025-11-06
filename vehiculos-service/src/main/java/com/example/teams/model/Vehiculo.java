package com.example.teams.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("vehiculos")
public record Vehiculo(
        @Id Integer id,
        String placa,
        String marca,
        String modelo,
        Integer clienteId
) {}

package com.example.players.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("clientes")
public record Cliente(
        @Id Integer id,
        String fullName,
        String documento,
        String telefono
) {}

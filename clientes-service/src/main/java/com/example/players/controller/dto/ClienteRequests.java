package com.example.players.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteRequests {
    public record Create(@NotBlank String fullName,
                         @NotBlank String documento,
                         String telefono) {}
    public record Update(@NotBlank String fullName,
                         @NotBlank String documento,
                         String telefono) {}
}

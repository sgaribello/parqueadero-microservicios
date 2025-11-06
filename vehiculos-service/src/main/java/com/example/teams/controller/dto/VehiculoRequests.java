package com.example.teams.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class VehiculoRequests {
    public record Create(@NotBlank String placa,
                        @NotBlank String marca,
                        @NotBlank String modelo,
                        Integer clienteId) {}
    public record Update(@NotBlank String placa,
                        @NotBlank String marca,
                        @NotBlank String modelo,
                        Integer clienteId) {}
}

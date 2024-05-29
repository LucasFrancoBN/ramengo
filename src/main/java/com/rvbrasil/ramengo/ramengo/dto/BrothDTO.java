package com.rvbrasil.ramengo.ramengo.dto;

import jakarta.persistence.Id;

import java.util.UUID;

public record BrothDTO(
    UUID id,
    String imageInactive,
    String imageActive,
    String name,
    String description,
    double price
) {
}

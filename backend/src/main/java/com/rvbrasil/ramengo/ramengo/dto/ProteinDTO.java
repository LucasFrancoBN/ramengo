package com.rvbrasil.ramengo.ramengo.dto;

import java.util.UUID;

public record ProteinDTO(
    UUID id,
    String imageInactive,
    String imageActive,
    String name,
    String description,
    double price
) {
}

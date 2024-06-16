package com.rvbrasil.ramengo.ramengo.dto;

import java.util.UUID;

public record OrderRequestDTO(
    UUID brothId,
    UUID proteinId
) {
}

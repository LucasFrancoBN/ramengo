package com.rvbrasil.ramengo.ramengo.dto;

import java.util.UUID;

public record OrderRequest(
    UUID brothId,
    UUID proteinId
) {
}

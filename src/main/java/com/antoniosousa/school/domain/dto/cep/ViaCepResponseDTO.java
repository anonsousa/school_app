package com.antoniosousa.school.domain.dto.cep;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ViaCepResponseDTO(
        @JsonProperty("logradouro")String street,
        @JsonProperty("localidade")String city,
        @JsonProperty("estado")String state
) {
}

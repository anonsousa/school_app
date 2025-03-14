package com.antoniosousa.school.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record ViaCepResponseDto(
        @JsonProperty("logradouro")String street,
        @JsonProperty("localidade")String city,
        @JsonProperty("uf")String state
) {
}

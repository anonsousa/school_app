package com.antoniosousa.school.domain.dto.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressInputDTO(

        @NotBlank String street,

        @NotBlank String number,

        @NotBlank
        @Size(min = 3, max = 35)
        String city,

        @NotBlank
        @Size(min = 4, max = 25)
        String state,

        @NotBlank
        @Pattern(regexp = "\\d{8}", message = "Zip code must have exactly 8 digits")
        String zipCode
) { }

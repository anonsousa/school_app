package com.antoniosousa.school.service;


import com.antoniosousa.school.domain.dto.ViaCepResponseDto;
import com.antoniosousa.school.domain.exception.cep.CepNotFoundException;
import com.antoniosousa.school.domain.exception.cep.InvalidCepFormatException;
import com.antoniosousa.school.domain.service.ViaCepService;
import com.antoniosousa.school.integration.ViaCepClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ViaCepServiceTest {

    @Mock
    private ViaCepClient viaCepClient;

    @InjectMocks
    private ViaCepService viaCepService;

    private ViaCepResponseDto viaCepResponseDto;
    private final String validCep = "01001000";
    private final String invalidCep = "00000000";
    private final List<String> invalidCeps = List.of("0000", "1234-567", "ABC12345", "1234567");

    @BeforeEach
    void setUp() {
        viaCepResponseDto = new ViaCepResponseDto(
                "Praça da Sé",
                "São Paulo",
                "São Paulo");
    }

    @Test
    void shouldReturnCepDetailsWhenValidCepIsProvided() {

        Mockito.when(viaCepClient.viewCep(validCep)).thenReturn(viaCepResponseDto);

        ViaCepResponseDto response = viaCepService.viewCep(validCep);


        Assertions.assertNotNull(response);
        Assertions.assertEquals("São Paulo", response.city());
        Assertions.assertEquals("São Paulo", response.state());
    }

    @Test
    void shoultThrowCepNotFoundExceptionWhenInvalidCepIsProvided() {

        Mockito.when(viaCepClient.viewCep(invalidCep)).thenReturn(null);

        Assertions.assertThrows(CepNotFoundException.class, () -> viaCepService.viewCep(invalidCep));
    }

    @Test
    void shouldThrowInvalidCepFormatExceptionWhenCepIsInvalid() {
        for (String invalidCep : invalidCeps) {
            Assertions.assertThrows(InvalidCepFormatException.class, () -> viaCepService.viewCep(invalidCep));
        }
    }






















}

package com.antoniosousa.school.controller;

import com.antoniosousa.school.domain.dto.cep.ViaCepResponseDTO;
import com.antoniosousa.school.domain.service.ViaCepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ViaCepControllerTest {

    @InjectMocks
    private ViaCepController viaCepController;

    @Mock
    private ViaCepService viaCepService;

    @Test
    void shouldReturnViaCepResponseDtoWhenValidCep() {
        String cep = "01001000";
        ViaCepResponseDTO expectedResponse = new ViaCepResponseDTO("Praça da Sé", "São Paulo", "São Paulo");

        when(viaCepService.viewCep(cep)).thenReturn(expectedResponse);

        ResponseEntity<ViaCepResponseDTO> response = viaCepController.viewCep(cep);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(viaCepService, times(1)).viewCep(cep);
    }
}

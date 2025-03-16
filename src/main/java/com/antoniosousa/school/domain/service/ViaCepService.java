package com.antoniosousa.school.domain.service;

import com.antoniosousa.school.domain.dto.ViaCepResponseDto;
import com.antoniosousa.school.domain.exception.CepNotFoundException;
import com.antoniosousa.school.integration.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCepResponseDto viewCep(String cep) {
        ViaCepResponseDto response = viaCepClient.viewCep(cep);
        if (response == null) {
            throw new CepNotFoundException("CEP not found: " + cep);
        }
        return response;
    }
}

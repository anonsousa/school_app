package com.antoniosousa.school.domain.service;

import com.antoniosousa.school.domain.dto.ViaCepResponseDto;
import com.antoniosousa.school.domain.exception.cep.CepNotFoundException;
import com.antoniosousa.school.domain.exception.cep.InvalidCepFormatException;
import com.antoniosousa.school.integration.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepClient viaCepClient;

    public ViaCepService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    public ViaCepResponseDto viewCep(String cep) {
        checkCepFormat(cep);

        ViaCepResponseDto response = viaCepClient.viewCep(cep);
        if (response == null || (response.city() == null && response.state() == null)) {
            throw new CepNotFoundException("CEP not found: " + cep);
        }
        return response;
    }


    private void checkCepFormat(String cep) {
        if (!cep.matches("\\d{8}")) {
            throw new InvalidCepFormatException("Invalid CEP format, must have 8 digits without spaces and symbols.");
        }
    }
}

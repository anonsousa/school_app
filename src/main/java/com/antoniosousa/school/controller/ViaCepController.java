package com.antoniosousa.school.controller;

import com.antoniosousa.school.domain.dto.ViaCepResponseDto;
import com.antoniosousa.school.domain.service.ViaCepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @Operation(summary = "Search for specific CEP", description = "Return CEP data using API ViaCEP.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CEP successfully returned"),
            @ApiResponse(responseCode = "400", description = "CEP not found"),
            @ApiResponse(responseCode = "404", description = "Bad Request (as invalid CEP format)")
    })
    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponseDto> viewCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok().body(viaCepService.viewCep(cep));
    }
}

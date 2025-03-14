package com.antoniosousa.school.controller;


import com.antoniosousa.school.domain.dto.ViaCepResponseDto;
import com.antoniosousa.school.domain.service.ViaCepService;
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

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponseDto> viewCep(@PathVariable("cep") String cep) {
        return ResponseEntity.ok().body(viaCepService.viewCep(cep));
    }
}

package com.antoniosousa.school.domain.dto.teacher;

import com.antoniosousa.school.domain.enums.ContractType;
import com.antoniosousa.school.domain.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TeacherResponseDTO(
        Long id,
        String fullName,
        String email,
        String phone,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate hireDate,
        EmployeeStatus status,
        ContractType contractType,
        BigDecimal salary
) { }

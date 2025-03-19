package com.antoniosousa.school.domain.dto.teacher;

import com.antoniosousa.school.domain.enums.ContractType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TeacherRequestDTO(
        @NotBlank
        @Size(min = 3, max = 20)
        String firstName,

        @NotBlank
        @Size(min = 3, max = 20)
        String lastName,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        @Email
        String email,

        @Past LocalDate birthDate,

        @NotBlank
        @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?9\\d{4}-\\d{4}$",
                message = "Invalid phone number. Correct format: (XX) 9XXXX-XXXX.")
        String phone,

        @NotNull @Valid AddressInputDTO address,

        LocalDate hireDate,

        @NotNull ContractType contractType,

        @Digits(integer = 6, fraction = 2)
        BigDecimal salary
) { }

package com.devjoliveira.challenge3_devsuperior.dto;

import java.time.LocalDate;

import com.devjoliveira.challenge3_devsuperior.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record ClinetDto(
        Long id,
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Cpf is required") String cpf,
        @NotBlank(message = "Salary is required") @Positive(message = "Salary need to be positive") Double income,
        @NotBlank(message = "Birthdate is required") @PastOrPresent(message = "Birthdate can't be in furure") LocalDate birthDate,
        @NotBlank(message = "Qtd of children need to be zero or greater") Integer children) {

    public ClinetDto(Client client) {
        this(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getIncome(),
                client.getBirthDate(),
                client.getChildren());
    }

}

package com.devjoliveira.challenge3_devsuperior.dto;

import java.time.LocalDate;

import com.devjoliveira.challenge3_devsuperior.entities.Client;

public record ClinetDto(
        Long id,
        String name,
        String cpf,
        Double income,
        LocalDate birthDate,
        Integer children) {

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

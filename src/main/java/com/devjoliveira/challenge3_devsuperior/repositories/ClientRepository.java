package com.devjoliveira.challenge3_devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjoliveira.challenge3_devsuperior.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

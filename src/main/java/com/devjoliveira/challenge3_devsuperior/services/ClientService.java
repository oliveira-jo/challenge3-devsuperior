
package com.devjoliveira.challenge3_devsuperior.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devjoliveira.challenge3_devsuperior.dto.ClinetDto;
import com.devjoliveira.challenge3_devsuperior.entities.Client;
import com.devjoliveira.challenge3_devsuperior.repositories.ClientRepository;

@Service
public class ClientService {

  private ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClinetDto findById(Long id) {

    Client entity = clientRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Client not found"));

    return new ClinetDto(entity);

  }

  public Page<ClinetDto> findAll(Pageable pageable) {

    Page<Client> page = clientRepository.findAll(pageable);

    return page.map(ClinetDto::new);

  }

}
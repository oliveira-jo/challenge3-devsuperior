
package com.devjoliveira.challenge3_devsuperior.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devjoliveira.challenge3_devsuperior.dto.ClinetDto;
import com.devjoliveira.challenge3_devsuperior.entities.Client;
import com.devjoliveira.challenge3_devsuperior.repositories.ClientRepository;
import com.devjoliveira.challenge3_devsuperior.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

  private ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClinetDto findById(Long id) {

    Client entity = clientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

    return new ClinetDto(entity);

  }

  public Page<ClinetDto> findAll(Pageable pageable) {

    Page<Client> page = clientRepository.findAll(pageable);

    return page.map(ClinetDto::new);

  }

  public ClinetDto save(ClinetDto dto) {

    return new ClinetDto(
        clientRepository.save(
            new Client(dto)));
  }

  public ClinetDto change(Long id, ClinetDto dto) {

    Client fromDB = clientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

    fromDB.setName(dto.name());
    fromDB.setCpf(dto.cpf());
    fromDB.setIncome(dto.income());
    fromDB.setBirthDate(dto.birthDate());
    fromDB.setChildren(dto.children());

    return new ClinetDto(
        clientRepository.save(fromDB));
  }

  public void delete(Long id) {
    Client fromDB = clientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

    clientRepository.delete(fromDB);

  }

}
package com.devjoliveira.challenge3_devsuperior.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoliveira.challenge3_devsuperior.dto.ClinetDto;
import com.devjoliveira.challenge3_devsuperior.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClinetDto> findById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.findById(id));
  }

  @GetMapping
  public ResponseEntity<Page<ClinetDto>> findAll(Pageable pageable) {
    return ResponseEntity.ok(clientService.findAll(pageable));
  }

  @PostMapping
  public ResponseEntity<ClinetDto> save(@RequestBody ClinetDto dto) {
    return ResponseEntity.ok(clientService.save(dto));
  }

}

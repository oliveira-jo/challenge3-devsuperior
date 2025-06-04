package com.devjoliveira.challenge3_devsuperior.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devjoliveira.challenge3_devsuperior.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.findById(id));
  }
}

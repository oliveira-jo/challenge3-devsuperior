package com.devjoliveira.challenge3_devsuperior.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devjoliveira.challenge3_devsuperior.dto.ClinetDto;
import com.devjoliveira.challenge3_devsuperior.services.ClientService;

import jakarta.validation.Valid;

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
  public ResponseEntity<ClinetDto> save(@Valid @RequestBody ClinetDto dto) {
    dto = clientService.save(dto);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(dto.id()).toUri();

    return ResponseEntity.created(uri).body(dto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClinetDto> change(@PathVariable Long id, @Valid @RequestBody ClinetDto dto) {
    return ResponseEntity.ok(clientService.change(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    clientService.delete(id);
    return ResponseEntity.ok().build();
  }

}

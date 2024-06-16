package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.ProteinDTO;
import com.rvbrasil.ramengo.ramengo.services.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ramengo/proteins")
public class ProteinController {
  @Autowired
  private ProteinService service;

  @GetMapping
  public ResponseEntity<List<ProteinDTO>> findAll(Pageable pageable) {
    return ResponseEntity.ok(service.findAll(pageable));
  }
}

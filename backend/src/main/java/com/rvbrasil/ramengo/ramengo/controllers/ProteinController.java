package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.ProteinDTO;
import com.rvbrasil.ramengo.ramengo.services.ProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ramengo/proteins")
public class ProteinController {
  @Autowired
  private ProteinService service;

  @GetMapping
  public Page<ProteinDTO> findAll(Pageable pageable) {
    return service.findAll(pageable);
  }
}

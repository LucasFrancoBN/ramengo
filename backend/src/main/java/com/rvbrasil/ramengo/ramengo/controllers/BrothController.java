package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.BrothDTO;
import com.rvbrasil.ramengo.ramengo.services.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ramengo/broths")
public class BrothController {
  @Autowired
  private BrothService service;

  @GetMapping
  public ResponseEntity<List<BrothDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}

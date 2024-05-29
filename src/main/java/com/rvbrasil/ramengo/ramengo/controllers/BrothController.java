package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.BrothDTO;
import com.rvbrasil.ramengo.ramengo.entities.Broth;
import com.rvbrasil.ramengo.ramengo.services.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ramengo/broths")
public class BrothController {
  @Autowired
  private BrothService service;

  @GetMapping
  public Page<BrothDTO> findAll(Pageable pageable) {
    return service.findAll(pageable);
  }
}

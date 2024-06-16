package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.OrderRequestDTO;
import com.rvbrasil.ramengo.ramengo.entities.OrderRequest;
import com.rvbrasil.ramengo.ramengo.entities.OrderResponse;
import com.rvbrasil.ramengo.ramengo.repositories.OrderRequestRepository;
import com.rvbrasil.ramengo.ramengo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ramengo/orders")
public class OrderController {
  @Autowired
  private OrderService service;
  @Autowired
  private OrderRequestRepository orderRequestRepository;


  @GetMapping
  @Transactional
  public List<OrderRequest> findAll() {
    return orderRequestRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<OrderResponse> save (@RequestBody OrderRequestDTO request) {
    OrderResponse orderResponse = service.save(request);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(orderResponse.getId());
    return ResponseEntity.created(uri).body(orderResponse);
  }
}

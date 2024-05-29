package com.rvbrasil.ramengo.ramengo.controllers;

import com.rvbrasil.ramengo.ramengo.dto.OrderRequest;
import com.rvbrasil.ramengo.ramengo.entities.OrderResponse;
import com.rvbrasil.ramengo.ramengo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ramengo/orders")
public class OrderController {
  @Autowired
  private OrderService service;

  @PostMapping
  public OrderResponse save (@RequestBody OrderRequest request) {
    return service.save(request);
  }
}

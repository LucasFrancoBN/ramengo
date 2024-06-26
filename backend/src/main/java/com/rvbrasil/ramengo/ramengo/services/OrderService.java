package com.rvbrasil.ramengo.ramengo.services;

import com.rvbrasil.ramengo.ramengo.dto.OrderId;
import com.rvbrasil.ramengo.ramengo.dto.OrderRequestDTO;
import com.rvbrasil.ramengo.ramengo.entities.*;
import com.rvbrasil.ramengo.ramengo.entities.enums.StatusOrderRequest;
import com.rvbrasil.ramengo.ramengo.exceptions.ErrorException;
import com.rvbrasil.ramengo.ramengo.repositories.BrothRepository;
import com.rvbrasil.ramengo.ramengo.repositories.OrderRequestRepository;
import com.rvbrasil.ramengo.ramengo.repositories.OrderResponseRepository;
import com.rvbrasil.ramengo.ramengo.repositories.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class OrderService {
  @Autowired
  private OrderResponseRepository repository;
  @Autowired
  private OrderRequestRepository requestRepository;
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private BrothRepository brothRepository;
  @Autowired
  private ProteinRepository proteinRepository;

  @Value("${x-api-key}")
  private String key;

  @Value("${url}")
  private String url;

  @Transactional
  public OrderResponse save(OrderRequestDTO orderRequestDTO) {
    Broth broth = brothRepository.findById(orderRequestDTO.brothId()).orElseThrow(() -> new ErrorException("Broth id not found"));
    Protein protein = proteinRepository.findById(orderRequestDTO.proteinId()).orElseThrow(() -> new ErrorException("Protein id not found"));

    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_JSON);
    header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    header.add("x-api-key", key);

    HttpEntity<OrderRequestDTO> requestEntity = new HttpEntity<>(orderRequestDTO, header);
    ResponseEntity<OrderId> response = restTemplate.postForEntity(url, requestEntity, OrderId.class);

    if(!response.getStatusCode().is2xxSuccessful()) {
      requestRepository.save(new OrderRequest(broth, protein, StatusOrderRequest.INCOMPLETE));
      throw new ErrorException("could not place order");
    }
    OrderId responseBody = response.getBody();
    assert responseBody != null : "response body is null";
    OrderResponse orderResponse = new OrderResponse(
        responseBody.orderId(),
        broth.getName() + " and " + protein.getName() + " Ramen",
        "./assets/ramens/" + protein.getName() + ".png");
    requestRepository.save(new OrderRequest(broth, protein, StatusOrderRequest.COMPLETE));
    return repository.save(orderResponse);
  }
}

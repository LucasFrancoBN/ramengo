package com.rvbrasil.ramengo.ramengo.entities;

import com.rvbrasil.ramengo.ramengo.entities.enums.StatusOrderRequest;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_order_request")
public class OrderRequest {
  @EmbeddedId
  private OrderRequestPK id = new OrderRequestPK();
  @CreationTimestamp
  private Instant timestamp;
  private StatusOrderRequest status;

  public OrderRequest(UUID brothId, UUID proteinId, StatusOrderRequest status) {
    this.id.setBrothId(brothId);
    this.id.setProteinId(proteinId);
    this.status = status;
  }

  public OrderRequest() {
  }

  public OrderRequestPK getId() {
    return id;
  }

  public void setId(OrderRequestPK id) {
    this.id = id;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public StatusOrderRequest getStatus() {
    return status;
  }

  public void setStatus(StatusOrderRequest status) {
    this.status = status;
  }
}

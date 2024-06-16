package com.rvbrasil.ramengo.ramengo.entities;

import com.rvbrasil.ramengo.ramengo.entities.enums.StatusOrderRequest;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order_request")
public class OrderRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "broth_id")
  private Broth broth;
  @ManyToOne
  @JoinColumn(name = "protein_id")
  private Protein protein;
  @CreationTimestamp
  private Instant createAt;
  private StatusOrderRequest status;

  public OrderRequest(Broth broth, Protein protein, StatusOrderRequest status) {
    this.broth = broth;
    this.protein = protein;
    this.status = status;
  }

  public OrderRequest() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Broth getBroth() {
    return broth;
  }

  public void setBroth(Broth broth) {
    this.broth = broth;
  }

  public Protein getProtein() {
    return protein;
  }

  public void setProtein(Protein protein) {
    this.protein = protein;
  }

  public Instant getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Instant createAt) {
    this.createAt = createAt;
  }

  public StatusOrderRequest getStatus() {
    return status;
  }

  public void setStatus(StatusOrderRequest status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderRequest that = (OrderRequest) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}

package com.rvbrasil.ramengo.ramengo.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_order_response")
public class OrderResponse {
  @Id
  private String id;
  private String description;
  private String image;

  public OrderResponse() {
  }

  public OrderResponse(String id, String description, String image) {
    this.id = id;
    this.description = description;
    this.image = image;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderResponse that = (OrderResponse) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}

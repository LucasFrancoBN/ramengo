package com.rvbrasil.ramengo.ramengo.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class OrderRequestPK {
  private UUID brothId;
  private UUID proteinId;

  public OrderRequestPK(UUID brothId, UUID proteinId) {
    this.brothId = brothId;
    this.proteinId = proteinId;
  }

  public OrderRequestPK() {
  }

  public UUID getBrothId() {
    return brothId;
  }

  public void setBrothId(UUID brothId) {
    this.brothId = brothId;
  }

  public UUID getProteinId() {
    return proteinId;
  }

  public void setProteinId(UUID proteinId) {
    this.proteinId = proteinId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderRequestPK that = (OrderRequestPK) o;
    return Objects.equals(brothId, that.brothId) && Objects.equals(proteinId, that.proteinId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brothId, proteinId);
  }
}

package com.rvbrasil.ramengo.ramengo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_protein")
public class Protein {
  @Id
  private UUID id;
  private String imageInactive;
  private String imageActive;
  private String name;
  private String description;
  private double price;
  @OneToMany(mappedBy = "id.proteinId")
  private final Set<OrderRequest> orderRequests = new HashSet<>();

  public Protein() {}

  public Protein(UUID id, String imageInactive, String imageActive, String name, String description, double price) {
    this.id = id;
    this.imageInactive = imageInactive;
    this.imageActive = imageActive;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  @PrePersist
  public void prePersist() {
    if(id == null) {
      id = UUID.randomUUID();
    }
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getImageInactive() {
    return imageInactive;
  }

  public void setImageInactive(String imageInactive) {
    this.imageInactive = imageInactive;
  }

  public String getImageActive() {
    return imageActive;
  }

  public void setImageActive(String imageActive) {
    this.imageActive = imageActive;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Set<OrderRequest> getOrderRequests() {
    return orderRequests;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Protein protein = (Protein) o;
    return Objects.equals(id, protein.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}

package com.rvbrasil.ramengo.ramengo.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_broth")
public class Broth {
  @Id
  private UUID id;
  private String imageInactive;
  private String imageActive;
  private String name;
  private String description;
  private double price;
  @ManyToMany
  @JoinTable(name = "tb_order_request",
             joinColumns = @JoinColumn(name = "brothId"),
             inverseJoinColumns = @JoinColumn(name = "proteinId")
  )
  Set<Protein> proteins = new HashSet<>();

  public Broth() {}

  public Broth(UUID id, String imageInactive, String imageActive, String name, String description, double price) {
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

  public Set<Protein> getProteins() {
    return proteins;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Broth broth = (Broth) o;
    return Objects.equals(id, broth.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}

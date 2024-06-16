package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.dto.ProteinDTO;
import com.rvbrasil.ramengo.ramengo.entities.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProteinRepository extends JpaRepository<Protein, String> {
  @Query("SELECT new com.rvbrasil.ramengo.ramengo.dto.ProteinDTO(p.id, p.imageInactive, p.imageActive, p.name, p.description, p.price) FROM Protein p")
  List<ProteinDTO> searchAll();

  Optional<Protein> findById(UUID id);
}

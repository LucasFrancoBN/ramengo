package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.dto.ProteinDTO;
import com.rvbrasil.ramengo.ramengo.entities.Protein;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProteinRepository extends JpaRepository<Protein, String> {
  @Query("SELECT new com.rvbrasil.ramengo.ramengo.dto.ProteinDTO(p.id, p.name, p.description, p.imageActive, p.imageInactive, p.price) FROM Protein p")
  Page<ProteinDTO> searchPageable(Pageable pageable);

  Optional<Protein> findById(UUID id);
}

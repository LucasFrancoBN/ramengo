package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.dto.BrothDTO;
import com.rvbrasil.ramengo.ramengo.entities.Broth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BrothRepository extends JpaRepository<Broth, String> {
  @Query("SELECT new com.rvbrasil.ramengo.ramengo.dto.BrothDTO(b.id, b.name, b.description, b.imageActive, b.imageInactive, b.price) FROM Broth b")
  Page<BrothDTO> searchPageable(Pageable pageable);

  Optional<Broth> findById(UUID id);
}

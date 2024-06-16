package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.dto.BrothDTO;
import com.rvbrasil.ramengo.ramengo.entities.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrothRepository extends JpaRepository<Broth, String> {
  @Query("SELECT new com.rvbrasil.ramengo.ramengo.dto.BrothDTO(obj.id, obj.imageInactive, obj.imageActive, obj.name, obj.description, obj.price) FROM Broth obj")
  List<BrothDTO> searchAll();

  Optional<Broth> findById(UUID id);
}

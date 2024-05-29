package com.rvbrasil.ramengo.ramengo.services;

import com.rvbrasil.ramengo.ramengo.dto.ProteinDTO;
import com.rvbrasil.ramengo.ramengo.entities.Broth;
import com.rvbrasil.ramengo.ramengo.entities.Protein;
import com.rvbrasil.ramengo.ramengo.repositories.BrothRepository;
import com.rvbrasil.ramengo.ramengo.repositories.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProteinService {
  @Autowired
  private ProteinRepository repository;

  @Transactional(readOnly = true)
  public Page<ProteinDTO> findAll(Pageable pageable) {
    return repository.searchPageable(pageable);
  }
}

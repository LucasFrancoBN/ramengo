package com.rvbrasil.ramengo.ramengo.services;

import com.rvbrasil.ramengo.ramengo.dto.BrothDTO;
import com.rvbrasil.ramengo.ramengo.repositories.BrothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrothService {
  @Autowired
  private BrothRepository repository;

  @Transactional(readOnly = true)
  public Page<BrothDTO> findAll(Pageable pageable) {
    return repository.searchPageable(pageable);
  }
}

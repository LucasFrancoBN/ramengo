package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.entities.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestRepository extends JpaRepository<OrderRequest, Long> {
}

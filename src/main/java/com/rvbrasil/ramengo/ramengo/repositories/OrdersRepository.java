package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.entities.OrderResponse;
import com.rvbrasil.ramengo.ramengo.entities.Protein;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderResponse, String> {
}

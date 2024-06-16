package com.rvbrasil.ramengo.ramengo.repositories;

import com.rvbrasil.ramengo.ramengo.entities.OrderRequestPK;
import com.rvbrasil.ramengo.ramengo.entities.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderResponseRepository extends JpaRepository<OrderResponse, OrderRequestPK> {
}

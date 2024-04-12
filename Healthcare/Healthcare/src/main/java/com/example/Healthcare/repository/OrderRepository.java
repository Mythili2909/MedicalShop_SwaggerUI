package com.example.Healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Healthcare.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

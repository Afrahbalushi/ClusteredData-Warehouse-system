package com.example.ClusteredData.Warehouse.Repositories;

import com.example.ClusteredData.Warehouse.Entities.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, String> {
}